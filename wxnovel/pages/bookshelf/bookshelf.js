// pages/bookshelf/bookshelf.js
Page({

  /**
   * 页面的初始数据
   * user是从缓存中的获取到数据
   */
  data: {
    user:"",
    bookshelf:[],
    dialogShow: false,
    showOneButtonDialog: false,
    buttons: [{ text: '取消' }, { text: '确定' }],
  },

  openConfirm: function () {
    this.setData({
      dialogShow: true
    })
  },

  tapDialogButton(e) {
    console.log()
    if (e.detail.index==1){
      console.log("点击了确定")
    }else{
      console.log("点击了取消")
    }
    this.setData({
      dialogShow: false,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#c59ebb',
      animation: {
        duration: 400,
        timingFunc: 'easeIn'
      }
    })
    var that=this
    wx.request({
      url: 'http://localhost:8080/getshelfs',
      data:{
        "userid": wx.getStorageSync('user').userid
      },
      success:function(res){
        that.setData({
          bookshelf:res.data
        })
      }
    })
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