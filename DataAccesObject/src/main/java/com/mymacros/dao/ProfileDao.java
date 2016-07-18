package com.mymacros.dao;

import com.mymacros.dto.entity.ProfileDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface ProfileDao
{
     List<ProfileDto> getAllProfiles();
     ProfileDto getProfile(long id);
     void createProfile(ProfileDto profileDto);
     void deleteProfile(long id);
}
