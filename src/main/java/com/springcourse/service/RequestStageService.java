package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;
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
		return result.get();
	}

	public List<RequestStage> listAllByRequestId(Long requestId) {
		List<RequestStage> requestStages = requestStageRepository.findAllByRequestId(requestId);
		return requestStages;
	}

}
