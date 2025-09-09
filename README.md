<img width="894" height="1287" alt="101dcb69fbbe543a2847f0eb7f568de9" src="https://github.com/user-attachments/assets/f55ae462-323d-4945-899a-7dd585d981df" />


接口：
public interface Movement {
    void move(double deltaX, double deltaY);
    void jump();
    boolean isGrounded();
    void setVelocity(double x, double y);
    Point2D getVelocity();
}

public interface Input {
    void handleKeyPress(KeyEvent event);
    void handleKeyRelease(KeyEvent event);
    void addInputListener(InputListener listener);
    void removeInputListener(InputListener listener);
}

public interface Monitoring {
    void update(double elapsedTime);
    void registerForMonitoring(Monitorable object);
    void unregisterFromMonitoring(Monitorable object);
    G
    
public class GameEvent extends Event {
    public static final EventType<GameEvent> ANY = new EventType<>(Event.ANY, "GAME_EVENT");
    public static final EventType<GameEvent> PLAYER_MOVED = new EventType<>(ANY, "PLAYER_MOVED");
    public static final EventType<GameEvent> COLLISION_DETECTED = new EventType<>(ANY, "COLLISION_DETECTED");
    public static final EventType<GameEvent> LEVEL_COMPLETE = new EventType<>(ANY, "LEVEL_COMPLETE");
    // 更多事件类型...
    
private final Object source;
    private final Object data;
    
// 构造函数、getter方法等
}ameState getCurrentState();
}


public interface Renderable {
    

enum RenderLayer {
        BACKGROUND,      // 背景层 (-100)
        TERRAIN,         // 地形层 (-50)
        DECORATION,      // 装饰层 (-25)
        ENTITY,          // 实体层 (0) - 默认层
        EFFECT,          // 特效层 (50)
        UI,              // UI层 (100)
        OVERLAY          // 覆盖层 (150)
    }

项目介绍：本项目是一个单机游戏，通过方向键与鼠标来确定人物移动的方向和轨迹，在特定地点获得物品以及到达出口获得游戏胜利

关卡系统 
显示关卡: 通过 JavaFX Scene 渲染关卡元素

加载关卡配置: 从 JSON 文件加载关卡布局、元素位置和属性

判定过关: 监测玩家是否到达终点并完成所有条件

音频系统
BGM: 播放背景音乐

音效: 为不同游戏事件触发对应音效

物理系统
移动箱子: 实现推箱子物理逻辑

跳跃: 基于重力的跳跃机制

地形: 不同地形对移动的影响

游戏逻辑
获得宝物: 收集系统与分数计算

到达终点: 关卡完成条件检测

淘汰: 玩家死亡机制（重新开始加载）
、

参与贡献：
陈池，何宇航，林良耀，姜秋蕾，朱雅婷