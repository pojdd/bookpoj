// pages/bookshelf/bookshelf.js
Page({
  onTabItemTap(item){
    if(item.index==0){
      this.getBookShelf()
    }
  },

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
    temp:""
  },

  openConfirm: function (res) {
    this.setData({
      temp: res.target.dataset.index
    })
    this.setData({
      dialogShow: true
    })
  },

  tapDialogButton(e) {
    var that=this
    if (e.detail.index==1){
      console.log(this.data.bookshelf[this.data.temp])
      console.log(wx.getStorageSync('user').userid)
      wx.request({
        url: 'http://localhost:8080/bookshelf_del',
        data:{
          "userid": wx.getStorageSync('user').userid,
          "bookid": that.data.bookshelf[that.data.temp].bookid
        }
      })
      this.getBookShelf()
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
    this.getBookShelf()
  },

  getBookShelf:function(){
    var that=this
    wx.request({
      url: 'http://localhost:8080/getshelfs',
      data: {
        "userid": wx.getStorageSync('user').userid
      },
      success: function (res) {
        that.setData({
          bookshelf: res.data
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