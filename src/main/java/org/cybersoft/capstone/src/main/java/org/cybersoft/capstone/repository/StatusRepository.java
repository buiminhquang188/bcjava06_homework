package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.entity.StatusEntity;

import java.util.List;

public interface StatusRepository {
    List<StatusEntity> getStatuses();
}
