package link.ebbinghaus.planning.view.fragment;

/**
 * Created by WINFIELD on 2016/3/1.
 */
public interface PlanningDisplayAbstAllView {

    /**
     * 初始化RecyclerView
     */
    void initRecyclerView();


    /**
     * 为是否调用onCreateView设置标记
     */
    void setOnCreateViewFlag();
}
