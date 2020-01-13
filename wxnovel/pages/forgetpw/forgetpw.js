// pages/forgetpw/forgetpw.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    inputlock:true,
    user:"",
    password: "",
    account:"",
    email:""
  },
  
  getpw: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  getac: function (e) {
    this.setData({
      account: e.detail.value
    })
  },
  getemail: function (e) {
    this.setData({
      email: e.detail.value
    })
  },


  btn: function () {
    console.log(this.data.account)
    if (this.data.account == "" || this.data.password == "" || this.data.email == "") {
      wx.showToast({
        title: '账号密码邮箱不能为空！！',
        icon: 'none'
      })
    } else {
    wx.request({
      url: 'http://192.168.2.149:8080/update',
      data: {
        account: this.data.account,
        password: this.data.password,
        email: this.data.email
      },
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        if (res.data == 1) {
          wx.showToast({
            title: '请前往邮箱修改',
          })
          wx.navigateBack({

          })
        } else {
          wx.showToast({
            title: '修改失败',
          })

        }
      },
    })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(wx.getStorageSync("user"))
    if (wx.getStorageSync("user")){
    this.setData({
      user:wx.getStorageSync("user")
      })
      this.setData({
        account: wx.getStorageSync("user").account
      })
      this.setData({
        email: wx.getStorageSync("user").email
      })
      this.setData({
        inputlock: true
      })
    }else{
      this.setData({
        inputlock: false
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