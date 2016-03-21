package link.ebbinghaus.planning.presenter.impl;

import com.yurikami.lib.util.DateUtils;

import link.ebbinghaus.planning.model.PlanningBuildModel;
import link.ebbinghaus.planning.model.entity.po.DefaultInputValue;
import link.ebbinghaus.planning.model.entity.po.EventSubtype;
import link.ebbinghaus.planning.model.entity.vo.InputEventVo;
import link.ebbinghaus.planning.model.impl.PlanningBuildModelImpl;
import link.ebbinghaus.planning.presenter.PlanningBuildSpecificPresenter;
import link.ebbinghaus.planning.view.fragment.PlanningBuildSpecificView;

/**
 * Created by WINFIELD on 2016/3/14.
 */
public class PlanningBuildSpecificPresenterImpl implements PlanningBuildSpecificPresenter {
    private PlanningBuildSpecificView mPlanningBuildSpecificView;
    private PlanningBuildModel mPlanningBuildModel;

    public PlanningBuildSpecificPresenterImpl(PlanningBuildSpecificView planningBuildSpecificView) {
        this.mPlanningBuildSpecificView = planningBuildSpecificView;
        this.mPlanningBuildModel = new PlanningBuildModelImpl();
    }

    @Override
    public void getAndSetDefaultInputValues(InputEventVo inputEvent) {
        DefaultInputValue value = mPlanningBuildModel.findDefaultInputValue();
        mPlanningBuildSpecificView.setDefaultInputValue(value);
        inputEvent.setMaxWidth(value.getMaxWidth());
        inputEvent.setIsGreekAlphabetMarked(value.isGreekAlphabetMarked());
        inputEvent.setIsRemind(value.isRemind());
        inputEvent.setRemindTime(value.getRemindTime());
        inputEvent.setStrategy(value.getStrategy());
        inputEvent.setIsShowEventSequence(value.isShowEventSequence());
        //默认值,不在默认值数据表里,手动设置的
        inputEvent.setEventExpectedFinishedDate(DateUtils.currentDateTimestamp());
    }

    @Override
    public void switchBuildPanel() {
        mPlanningBuildSpecificView.setBuildPanel();
    }

    @Override
    public void configureEventSubtype(EventSubtype result) {
        mPlanningBuildSpecificView.setSubtype(result);
    }

    @Override
    public void configureFastTemplate() {
        mPlanningBuildSpecificView.setFastTemplate();
    }

    @Override
    public void configureStrategy() {
        mPlanningBuildSpecificView.setStrategy();
    }

    @Override
    public void configureExpectedFinishDate() {
        mPlanningBuildSpecificView.setExpectedFinishDate();
    }

    @Override
    public void configureRemind(boolean isChecked) {
        mPlanningBuildSpecificView.setRemind(isChecked);
    }

    @Override
    public void configureRemindTime() {
        mPlanningBuildSpecificView.setRemindTime();
    }

    @Override
    public void configureSequence(boolean isChecked) {
        mPlanningBuildSpecificView.setSequence(isChecked);
    }

    @Override
    public void configureGreekAlphabet(boolean isChecked) {
        mPlanningBuildSpecificView.setGreekAlphabet(isChecked);
    }

    @Override
    public void configureEventGroup() {
        mPlanningBuildSpecificView.setEventGroup();
    }

    @Override
    public void closeDB() {
        mPlanningBuildModel.closeDB();
    }
}
