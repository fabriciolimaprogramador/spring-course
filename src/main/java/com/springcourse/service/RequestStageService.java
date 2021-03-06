package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.exception.NotFoundException;
import com.springcourse.model.PageModel;
import com.springcourse.model.PageRequestModel;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Autowired
	private RequestRepository requestRepository;

	public RequestStage save(RequestStage requestStage) {

		requestStage.setRealizationDate(new Date());

		RequestStage createRequestStage = requestStageRepository.save(requestStage);

		Long requestId = requestStage.getId();
		RequestState state = requestStage.getState();

		requestRepository.updateStatus(requestId, state);

		return createRequestStage;
	}

	public RequestStage getById(Long id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.orElseThrow(() -> new NotFoundException("There are not request stage with id  = " + id));
	}

	public List<RequestStage> listAllByRequestId(Long requestId) {
		List<RequestStage> requestStages = requestStageRepository.findAllByRequestId(requestId);
		return requestStages;
	}
	
	public PageModel<RequestStage> listAllByRequestIdLazyModel(Long requestId, PageRequestModel pr) {

		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<RequestStage> page = requestStageRepository.findAllByRequestId(requestId, pageable);
		PageModel<RequestStage> pm = new PageModel<>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(),
				page.getContent());
		return pm;
	}

}
