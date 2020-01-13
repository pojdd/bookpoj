// pages/regist/regist.js
function ssss() {
  console.log('sssssss')
}
Page({

  /**
   * 页面的初始数据
   */
  data: {
    account: "",
    password: "",
    email: ""
  },     
checkEmail: function (email) {
     
    let str = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/
     
    if (str.test(email)) {
     
    return true
     
    } else {
     
  
     
    return false
     
    }
     
    },

  getac: function (e) {
    console.log(e.detail.value.length)
    if(e.detail.value.length >= 10){
      wx.showToast({
        title: '账号位数不能超出10位',
        icon:"none"
      })
    }
    this.setData({
      account: e.detail.value
    })
  },
  getpw: function (e) {
    if (e.detail.value.length >= 24) {
      wx.showToast({
        title: '账号位数不能超出24位',
        icon: "none"
      })
    }
    this.setData({
      password: e.detail.value
    })
  },
  getemail: function (e) {
    this.setData({
      email: e.detail.value
    })
  },




  btn: function () {
    let that = this
    if (this.data.account == "" || this.data.password == "" || this.data.email == "") {
      wx.showToast({
        title: '账号密码邮箱不能为空！！',
        icon: 'none'
      })
    } else {
      let email = this.data.email
      let checkedNum = this.checkEmail(email)
      if (checkedNum == true) {
        wx.request({
          url: 'http://localhost:8080/regist',
          data: {
            account: this.data.account,
            password: this.data.password,
            email: this.data.email
          },
          header: {
            'content-type': 'application/json'
          },
          success(res) {
            console.log(res.data)
            if (res.data == 1) {
              wx.showToast({
                title: '注册成功',
                duration: 1000,
              })
              setTimeout(function () {
                wx.navigateBack()
              }, 1000)
            } else {
              wx.showToast({
                title: '注册失败',
              })
            }
          },
        })
      }else{
        wx.showToast({
          title: '邮箱格式不正确',
          icon: "none"
        })
      }
      
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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