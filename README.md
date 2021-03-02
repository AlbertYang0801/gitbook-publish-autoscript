
## GitBook 一键同步 Github 脚本


### 介绍

本项目是一个 `GitBook 一键发布脚本`，解决 `GitBook` 发布到 `GitHub` 步骤的繁琐，支持手动同步和定时同步。

### 传统发布流程

![脚本执行流程](https://cdn.jsdelivr.net/gh/AlbertYang0801/pic-bed@main/img/20210224002103.png)

1. 编写 `md` 文章。

2. 使用 `gitbook build` 命令生成 `html` 静态文件，使用后会在 `GitBook` 基础文件目录`下的 `_book` 文件夹生成静态文件。

3. 复制 `_book` 文件夹下所有文件到 `Java项目` 根路径下。

4. 使用 `Git` 相关命令将 Java项目 `新增内容同步到 `GitHub`。

   *由于发布流程的第 2、3、4 步太过繁琐，故开发一个脚本，按照顺序执行 2、3、4 步完成自动发布的功能。*

### 使用说明

#### 手动同步

不需要部署服务器。

1.  跳转到手动脚本：[GitbookManualScript.java](src/main/java/com/albert/script/GitbookManualScript.java)
2.  手动指定必要参数。
    
    ```java
    /**
     * gitbook本地目录
     */
    private final static String GITBOOK_PATH = "/Users/yangjunwei/gitbook";
    /**
     * github对应本地项目目录
     */
    private final static String GITHUB_PROJECT_PATH = "/Users/yangjunwei/IdeaProjects/gitbook-technology";
    /**
     * github对应remote
     */
    private final static String GITHUB_REMOTE = "origin";
    /**
     * github分支名称
     */
    private final static String GITHUB_BRANCH = "main";
```
    
3. 执行 `main()` 方法

#### 定时同步

可部署到服务器，参考安装教程。

1. 修改配置文件：[application.properties](config/application.properties)

    ```java
    #gitbook本地目录
    gitbook.path=/Users/yangjunwei/gitbook
    #github项目本地路径
    github.project.path=/Users/yangjunwei/IdeaProjects/gitbook-technology
    #github的remote值
    github.remote=origin
    #github分支名称
    github.branch=main
    #定时同步gitbook的cron表达式
    auto.sync.gitbook.cron='0 0 23 * * *'
    ```

2.启动： [Application.java](src/main/java/com/albert/Application.java)

###  项目要求

- JDK 1.8
- Apache-maven

### 安装教程

1. 项目打包：`mvn clean package -Dmaven.test.skip=true`

2. 部署压缩包

   - 首次部署

     复制 `target` 目录下的 `gitbook-publish-autoscript-1.0-SNAPSHOT-bin.tar.gz` 并解压。

   - 非首次部署

     复制 `target` 目录下的 `gitbook-publish-autoscript-1.0-SNAPSHOT.jar` 到解压后的 `lib` 目录下。

3. 启动/停止项目

   - 启动

     执行 `bin` 目录下的 `start.sh`

   - 停止

     执行 `bin` 目录下的 `stop.sh`
