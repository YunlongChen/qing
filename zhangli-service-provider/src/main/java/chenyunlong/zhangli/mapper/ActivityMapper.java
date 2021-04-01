package chenyunlong.zhangli.mapper;

import chenyunlong.zhangli.model.entities.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ActivityMapper {

    List<Activity> getActivityList();

    Activity getActivityById(Long activityId);

    void insert(Activity activity);
}
