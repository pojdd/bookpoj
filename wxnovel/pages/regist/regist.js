// pages/regist/regist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    account:"",
    password:"",
    email:""
  },
  
  getac:function(e){
    this.setData({
      account:e.detail.value
    })
  },
  getpw: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  getemail: function (e) {
    this.setData({
      email: e.detail.value
    })
  },

btn:function(){
  wx.request({
    url: 'http://192.168.2.149:8080/regist',
    data:{
      account:this.data.account,
      password:this.data.password,
      email:this.data.email
    },
    header: {
      'content-type': 'application/json' },
    success(res){
      if(res.data==1){
        wx.showToast({
          title: '注册成功',
        })
        wx.navigateBack({

        })
      } else{
        
      }
    },
  })
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