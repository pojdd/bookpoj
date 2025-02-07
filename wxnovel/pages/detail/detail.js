// pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    book:"",
    ellipsis: true,
    isadded:true,
    relative:[],
  },

  /**
   * 收起/展开按钮点击事件
   */
  ellipsis: function () {
    var value = !this.data.ellipsis;
    this.setData({
      ellipsis: value
    })
  },

  vertifyState:function(){
      var that=this
      wx.request({
        url: 'http://localhost:8080/vertify',
        data:{
          "userid": wx.getStorageSync('user').userid,
          "bookid": that.data.book.bookid
        },
        success:function(res){
          console.log(res.data)
          that.setData({
            isadded:res.data
          })
        }
      })
  },

  addbookshelf:function(res){
    let that=this
    wx.request({
      url: 'http://localhost:8080/bookshelf_add',
      data:{
        "userid": wx.getStorageSync('user').userid,
        "bookid": that.data.book.bookid
      },
      success:function(res){
        if(res.data===1){
           wx.showToast({
             title: '成功加入书架！',
           })
        }
        var added = !that.data.isadded
        that.setData({
          isadded: added
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#9c9c9e',
      animation: {
        duration: 400,
        timingFunc: 'easeIn'
      }
    })
    const eventChannel = this.getOpenerEventChannel();
    eventChannel.on('bookdetail', function (data){
      that.setData({
        book:data
      })
    })
    this.vertifyState();
    this.getRelative();
  },

  getRelative:function(){
    var that=this
    var bookclassname=that.data.book.bookclass;
    var bookclassname1=bookclassname.split("[");
    var bookclassname2=bookclassname1[1].split(']');
    console.log(bookclassname1)
    console.log(that.data.book.bookclass);
    wx.request({
      url: 'http://localhost:8080/relativebook',
      data:{
        "bookrelative": bookclassname2[0],
      },
      success:function(res){
        that.setData({
          relative:res.data
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

  },

  loadchapters:function(){
    var that=this;
    const eventChannel = this.getOpenerEventChannel()
    wx.navigateTo({
      url: '/pages/chapters/chapters',
      success:function(res){
        res.eventChannel.emit('bookid', that.data.book.bookid)
      }
    })
  },
})