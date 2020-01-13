// pages/info/info.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: "杜乐乐",
    account: "1987633389",
    sex: "男",

    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
  },

  changepw:function(){
    wx.navigateTo({
      url: '/pages/forgetpw/forgetpw',
    })
    

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.app = getApp()
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.app.slideupshow(this, 'slide_up1', 0, 1)

    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up2', 0, 1)
    }.bind(this), 200);

    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up3', 0, 1)
    }.bind(this), 300);
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up4', 0, 1)
    }.bind(this), 400);
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up5', 0, 1)
    }.bind(this), 500);
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    this.app.slideupshow(this, 'slide_up1', 200, 0)
    //延时展现容器2，做到瀑布流的效果，见上面预览图
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up2', 200, 0)
    }.bind(this), 200);
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up3', 200, 0)
    }.bind(this), 300);
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up4', 200, 0)
    }.bind(this), 400);
    setTimeout(function () {
      this.app.slideupshow(this, 'slide_up5', 200, 0)
    }.bind(this), 500);
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})