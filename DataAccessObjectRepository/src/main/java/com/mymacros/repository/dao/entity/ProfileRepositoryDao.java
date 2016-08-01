package com.mymacros.repository.dao.entity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface ProfileRepositoryDao
{
     List<ProfileEntity> getAllProfiles(long id);
     ProfileEntity getProfile(long id);
     void createProfile(ProfileEntity profileDto);
     void updateProfile(ProfileEntity profileDto);
     void deleteProfile(long id);
}
