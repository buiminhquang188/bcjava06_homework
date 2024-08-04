package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.ProfileDTO;
import org.cybersoft.capstone.entity.ProfileEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.repository.ProfileRepository;
import org.cybersoft.capstone.repository.impl.ProfileRepositoryImpl;
import org.cybersoft.capstone.service.ProfileService;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository = new ProfileRepositoryImpl();

    @Override
    public ProfileEntity getProfile(Integer id) {
        return this.profileRepository.getProfile(id);
    }

    @Override
    public List<StatusEntity> getStatProfile(Integer id) {
        return this.profileRepository.getStatProfile(id);
    }

    @Override
    public Boolean updateProfile(ProfileDTO profileDTO, Integer userId) {
        Integer resultIndex = this.profileRepository.updateProfile(profileDTO, userId);
        return resultIndex > 0;
    }
}
