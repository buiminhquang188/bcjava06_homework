package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.entity.ProfileEntity;
import org.cybersoft.capstone.entity.StatusEntity;

import java.util.List;

public interface ProfileRepository {
    ProfileEntity getProfile(Integer id);

    List<StatusEntity> getStatProfile(Integer id);
}
