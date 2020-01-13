// pages/chapters/chapters.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chapters:[
      "第1章 化身BOSS【求推荐，求收藏】",
      "第2章 恐怖伤害【求推荐，求收藏】",
      "第3章 村霸【求推荐，求收藏】",
      "第4章 大杀四方【求推荐，求收藏】",
      "第5章 死【求推荐，求收藏】",
      "第6章 影幕森林【求推荐，求收藏】",
      "第7章 恐怖大法师【求推荐，求收藏】",
      "第8章 单人副本【求推荐，求收藏】",
      "第9章 大BOSS【求推荐，求收藏】",
      "第10章 第一件金装【求推荐，求收藏】",
      "第11章 屠杀【求推荐，求收藏】",
      "第12章 愤怒【求推荐，求收藏】",
      "第13章 你是神民【求推荐，求收藏】",
      "第14章 死吧【求推荐，求收藏】",
      "第15章 创建公会【求推荐，求收藏】",
      "第16章 鲁修【求推荐，求收藏】",
      "第17章 狂暴猪王【求推荐，求收藏】",
      "第18章 生死之交【求推荐，求收藏】",
      "第19章 双BOSS【求推荐，求收藏】"
    ],
    bookid:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
    const eventChannel = this.getOpenerEventChannel()
    // 获取事件通道的值
    eventChannel.on('bookid', function (data) {
      that.setData({
        bookid:data
      })
    })
    var that=this
    wx.request({
      url: 'http://localhost:8080/getChapters',
      data:{
        bookid:that.data.bookid
      },
      success:function(res){
        console.log(res.data)
        that.setData({
          chapters:res.data
        })
      }
    })
  },
  getDetail(e){
    let that=this
    console.log(e.currentTarget.dataset.chapterindex+1)
    wx.navigateTo({
      url: '/pages/content/content',
      success: function (res) {
        res.eventChannel.emit('content', that.data.chapters[e.currentTarget.dataset.chapterindex + 1])
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