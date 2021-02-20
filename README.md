

# gitbook一键同步github脚本

* [gitbook-publish-autoscript](#gitbook-publish-autoscript)
    * [介绍](#介绍)
    * [要求](#要求)
    * [使用说明](#使用说明)
      * [手动同步](#手动同步)
      * [定时同步](#定时同步)
    * [安装教程](#安装教程)


### 介绍

本项目是一个gitbook一键同步脚本，支持手动同步和定时同步。

按照图中顺序自动`gitbook build`，将生成的`_book`目录下所有文件复制到`github对应的本地项目`目录，然后提交到`github`上。

![脚本执行流程](https://cdn.jsdelivr.net/gh/AlbertYang0801/pic-bed@main/img/20210220183456.png)

- gitbook build

  > 执行完成之后在gitbook目录下的`_book`文件夹下面会生成静态文件。

- cpoy file

  > 将`_book`文件夹下面的所有文件复制到本地项目路径下。

- push Github

  > 提交本地项目新增内容到GitHub。



###  要求

- JDK 1.8

### 使用说明

#### 手动同步

> 不需要部署服务器

1.  跳转到手动脚本：[GitbookManualScript.java](src/main/java/com/albert/script/GitbookManualScript.java)
2.  手动指定必要参数

- gitbook本地目录
- github对应本地项目目录
- github对应remote
- github分支名称

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

3. 执行main()方法

#### 定时同步

> 可部署到服务器，参考安装教程

1. 修改配置文件：[application.properties](config/application.properties)

- gitbook本地目录
- github对应本地项目目录
- github对应remote
- github分支名称
- 定时同步gitbook的cron表达式

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

2.启动 [Application.java](src/main/java/com/albert/Application.java)

### 安装教程

1. 项目打包：`mvn clean package -Dmaven.test.skip=true`

2. 部署压缩包

   - 首次部署

     复制`target`目录下的`gitbook-publish-autoscript-1.0-SNAPSHOT-bin.tar.gz`并解压。

   - 非首次部署

     复制`target`目录下的`gitbook-publish-autoscript-1.0-SNAPSHOT.jar`到解压后的lib目录下。

3. 启动/停止项目

   - 启动

     执行`bin`目录下的`start.sh`

   - 停止

     执行`bin`目录下的`stop.sh`
