package link.ebbinghaus.planning.core.service;

import java.util.List;

import link.ebbinghaus.planning.core.model.local.po.Event;
import link.ebbinghaus.planning.core.model.local.sys.Tab;

/**
 * Created by WINFIELD on 2016/3/1.
 */
public interface PlanningDisplayAbstractService {

    /**
     * 创建PlanningBuildAbstract的最顶层tabs
     * @return PlanningBuildAbstract的tabs
     */
    List<Tab> makePlanningDisplayAbstractTabs();

    /**
     * 找出所有的模糊计划
     * @return
     */
    List<Event> findAllAbstEvent();

    /**
     *
     * @param pk 模糊计划主键
     * @param groupPk 模糊计划所关联的计划组主键
     */
    void removeAbstEvent(Long pk, Long groupPk);

}
