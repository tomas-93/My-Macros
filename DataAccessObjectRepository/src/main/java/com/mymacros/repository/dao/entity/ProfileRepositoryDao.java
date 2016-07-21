package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.ProfileDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface ProfileRepositoryDao extends IDBase
{
     List<ProfileDto> getAllProfiles(long id);
     ProfileDto getProfile(long id);
     void createProfile(ProfileDto profileDto);
     void updateProfile(ProfileDto profileDto);
     void deleteProfile(long id);
}
