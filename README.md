# BeyondtheWalls
BeyondtheWalls/
├── src/
│   ├── main/
│   │   ├── java/com/beyondthewalls/
│   │   │   ├── game/
│   │   │   │   ├── core/                    # 核心接口和事件系统
│   │   │   │   │   ├── Movement.java        # 移动接口
│   │   │   │   │   ├── Collision.java       # 碰撞接口
│   │   │   │   │   ├── Input.java           # 输入接口
│   │   │   │   │   ├── Renderable.java      # 渲染接口
│   │   │   │   │   ├── Monitoring.java      # 监测接口
│   │   │   │   │   └── GameEvent.java       # 游戏事件类
│   │   │   │   ├── entities/
│   │   │   │   │   ├── characters/          # 人物属性相关
│   │   │   │   │   │   ├── Player.java      # 玩家角色
│   │   │   │   │   │   ├── girl.java        # 女孩角色
│   │   │   │   │   │   └── cutecat.java     # 猫猫角色
│   │   │   │   │   ├── background/          # 背景相关
│   │   │   │   │   │   ├── BackgroundManager.java
│   │   │   │   │   │   ├── Terrain.java     # 地形系统
│   │   │   │   │   │   └── ParallaxLayer.java # 视差层
│   │   │   │   │   └── interaction/         # 交互相关
│   │   │   │   │       ├── Box.java         # 可移动箱子
│   │   │   │   │       ├── Treasure.java    # 宝物
│   │   │   │   │       ├── Goal.java        # 终点
│   │   │   │   │       └── Button.java      # 机关按钮
│   │   │   │   ├── managers/
│   │   │   │   │   ├── LevelManager.java    # 关卡管理
│   │   │   │   │   ├── AudioManager.java    # 音频管理
│   │   │   │   │   ├── CollisionManager.java # 碰撞管理
│   │   │   │   │   └── InputManager.java    # 输入管理
│   │   │   │   ├── utils/
│   │   │   │   │   ├── ConfigLoader.java    # 配置加载
│   │   │   │   │   ├── Constants.java       # 常量定义
│   │   │   │   │   └── ResourceLoader.java  # 资源加载
│   │   │   │   └── Main.java                # 应用入口
│   │   └── resources/
│   │       ├── levels/                      # 关卡配置文件
│   │       ├── audio/                       # 音频资源
│   │       ├── images/                      # 图像资源
│   │       └── styles/                      # CSS样式文件
├── build.gradle                             # Gradle构建配置
└── README.md


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

    
关卡系统
显示关卡: 通过 JavaFX Scene 渲染关卡元素

加载关卡配置: 从 JSON 文件加载关卡布局、元素位置和属性

判定过关: 监测玩家是否到达终点并完成所有条件

音频系统
BGM: 使用 MediaPlayer 播放背景音乐

音效: 为不同游戏事件触发对应音效

物理系统
移动箱子: 实现推箱子物理逻辑

跳跃: 基于重力的跳跃机制

地形: 不同地形对移动的影响（水地面，正常地面）

游戏逻辑
获得宝物: 收集系统与分数计算

到达终点: 关卡完成条件检测

淘汰: 玩家死亡机制（重新开始加载）
