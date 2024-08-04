package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.ProfileDTO;
import org.cybersoft.capstone.entity.ProfileEntity;
import org.cybersoft.capstone.entity.StatusEntity;

import java.util.List;

public interface ProfileService {
    ProfileEntity getProfile(Integer id);

    List<StatusEntity> getStatProfile(Integer id);

    Boolean updateProfile(ProfileDTO profileDTO, Integer userId);
}
