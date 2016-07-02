---
title: 自定义View之小试牛刀
date: 2016-07-01 09:17:28
tags:
- View
categories:
- Android
---
**自定义View对于Android程序猿来说都应该了解的，或者说一定要掌握。虽然Google提供的控件可以满足日常开发需求，但是总有些奇葩需求肯定是满足不了的，所以对于自定义View的开发，就必不可少了。**
<!-- more -->

>关于自定义View的基础学习推荐[GcsSloop自定义View系列](https://github.com/GcsSloop/AndroidNote/tree/master/CustomView)

## 首先看下面效果图
![check](http://o9o9d242i.bkt.clouddn.com/check.gif)

>实现上图的效果参考[这篇文章](https://github.com/GcsSloop/AndroidNote/blob/master/CustomView/Advance/%5B4%5DCanvas_PictureText.md)

## 再来这个效果图
![zombie](http://o9o9d242i.bkt.clouddn.com/zombie.gif)
>上面效果图是根据第一个Demo的扩展，具体源码会在文章结尾提供链接

## 最后一个效果图
![sport](http://o9o9d242i.bkt.clouddn.com/sport.gif)
>这个自定义View是模仿QQ运动的那个界面

### 下面具体对模仿QQ运动这个View实现步骤