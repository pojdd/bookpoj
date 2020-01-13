// pages/forgetpw/forgetpw.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    inputlock: true,
    user: "",
    password: "",
    password2: "",
    account: "",
    email: ""
  },

  getpw: function(e) {
    this.setData({
      password: e.detail.value
    })
  },
  getpw2: function (e) {
    this.setData({
      password2: e.detail.value
    })
  },
  getac: function(e) {
    this.setData({
      account: e.detail.value
    })
  },
  getemail: function(e) {
    this.setData({
      email: e.detail.value
    })
  },

  checkEmail: function(email) {

    let str = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/

    if (str.test(email)) {

      return true

    } else {



      return false

    }
  },

  btn: function() {
    var animation = wx.createAnimation({
      delay: 0,
      duration: 500,
      timingFunction: "ease",
    });
    if (this.data.account == "" || this.data.password == "" || this.data.email == "" || this.data.password2 == "") {
      if (this.data.account == "" ){
        animation.scale(1.125, 1.125).backgroundColor("red").step();
        animation.opacity(1).scale(1, 1).backgroundColor("white").step();
        this.setData({
          slide_ac: animation.export()
        })
      }
      if (this.data.password == "") {
        animation.scale(1.125, 1.125).backgroundColor("red").step();
        animation.opacity(1).scale(1, 1).backgroundColor("white").step();
        this.setData({
          slide_pw: animation.export()
        })
      }
      if (this.data.email == "") {
        animation.scale(1.125, 1.125).backgroundColor("red").step();
        animation.opacity(1).scale(1, 1).backgroundColor("white").step();
        this.setData({
          slide_email: animation.export()
        })
      }
      if (this.data.password2 == "") {
        animation.scale(1.125, 1.125).backgroundColor("red").step();
        animation.opacity(1).scale(1, 1).backgroundColor("white").step();
        this.setData({
          slide_pw2: animation.export()
        })
      }
      // wx.showToast({
      //   title: '账号密码邮箱不能为空！！',
      //   icon: 'none'
      // })
    } else {
      if(this.data.password==this.data.password2){
      let email = this.data.email
      let checkedNum = this.checkEmail(email)
      if (checkedNum == true) {
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
                icon: 'none'
              })
              wx.navigateBack({

              })
            } else {
              wx.showToast({
                title: '修改失败',
                icon: 'none'
              })

            }
          },
        })
      } else {
        wx.showToast({
          title: '邮箱格式不正确',
          icon: 'none'
        })
      }
    }else{wx.showToast({
      title: '两次密码不一致',
        icon: 'none'
    })}
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.setNavigationBarTitle({
      title: '修改密码',
    })
    console.log(wx.getStorageSync("user"))
    if (wx.getStorageSync("user")) {
      this.setData({
        user: wx.getStorageSync("user")
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
    } else {
      this.setData({
        inputlock: false
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})