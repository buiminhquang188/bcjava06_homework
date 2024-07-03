package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.repository.StatusRepository;
import org.cybersoft.capstone.repository.impl.StatusRepositoryImpl;
import org.cybersoft.capstone.service.StatusService;

import java.util.List;

public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository = new StatusRepositoryImpl();

    @Override
    public List<StatusEntity> getStatuses() {
        return this.statusRepository.getStatuses();
    }
}
