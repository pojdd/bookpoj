// pages/search/search.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    keys:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: '搜索',
    })
  },
  SearchInput:function(e){
    var that=this
    console.log(e.detail.value)
    wx.request({
      url: 'http://localhost:8080/Serach',
      data:{
        key: e.detail.value
      },
      success:function(res){
        console.log(res.data)
        that.setData({
          keys:res.data
        })
      }
    })
  },
  SearchConfirm:function(e){
    console.log(e.detail.value)
  },
  getbook:function(e){
    console.log("getbook:"+e.currentTarget.dataset.bookid)
    wx.request({
      url: 'http://localhost:8080/getBookDetailByid',
      data: {
        "bookid":e.currentTarget.dataset.bookid
      },
      success: function (res) {
        var book = res.data
        console.log(res.data)
        wx.navigateTo({
          url: '/pages/detail/detail',
          success: function (res) {
            console.log(res)
            res.eventChannel.emit('bookdetail', book)
          }
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