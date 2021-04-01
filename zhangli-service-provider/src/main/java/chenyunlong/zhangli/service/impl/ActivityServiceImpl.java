package chenyunlong.zhangli.service.impl;

import chenyunlong.zhangli.model.entities.Activity;
import chenyunlong.zhangli.mapper.ActivityMapper;
import chenyunlong.zhangli.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stan
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityMapper activityMapper;

    public ActivityServiceImpl(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }


    @Override
    public List<Activity> queryActivitiesByPage(String keyWorld) {
        return activityMapper.getActivityList();
    }

    @Override
    public Activity getActivityById(Long activityId) {
        return activityMapper.getActivityById(activityId);
    }

    @Override
    public void addActivity(Activity activity) {
        activityMapper.insert(activity);
    }
}
