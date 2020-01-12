// pages/login/login.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ac:"",
    pw:"",
    result:"",
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },

  getac:function(e){
    this.setData({
      ac:e.detail.value,
    })
  },
  getpw: function (e) {
    this.setData({
      pw: e.detail.value,
    })
  },
  toregist:function(){
    wx.navigateTo({
      url: '../regist/regist',
    })
  },
  forgetpw: function () {
    wx.navigateTo({
      url: '../forgetpw/forgetpw',
    })
  },
  login:function(){
    if (this.data.ac == "" && this.data.pw == ""){
      wx.showToast({
        title: '账号密码不能为空！！',
        icon:'none'
      })
    }else{
    var that=this;
    wx.request({
      url: 'http://localhost:8080/login',
      data:{
        account:this.data.ac,
        password:this.data.pw 
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res){
        console.log(res)
        that.setData({
          result:res.data
        })
        if (res.data==false){
          wx.showToast({
            title: '账号密码不正确！！',
            icon: 'none'
          })
        }
      }
    })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
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
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

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