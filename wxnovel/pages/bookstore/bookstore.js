// pages/bookstore/bookstore.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    background: ["https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1XNvasoQ0GU1S1JdL8t_IiuoIkzkFdGLjeXrehJxZekcqSuDuNQ&s","http://pic.51yuansu.com/backgd/cover/00/02/30/5b55a7417869f.jpg!/fw/780/quality/90/unsharp/true/compress/true"],
    fantsy:[],
    city:[],
    selfcultivation:[],
    girl:[],
    crossing:[],
    onlinegame:[],
    scifi:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getFantsyData()
    this.getCityData()
    this.getSelfcultivationData()
    this.getGirlData()
    this.getCrossingData()
    this.getOnlinegameData()
    this.getScifiData()
  },

    /*
    * bookstore_category_fantsy
    * bookstore_category_city
    * bookstore_category_self-cultivation
    * bookstore_category_romance
    * bookstore_category_girl
    * bookstore_category_crossing
    * bookstore_category_online-game
    * bookstore_category_sci-fi
    * */

    /**
     * getFantsyData use for get fantsy book
     * 
     */
  getFantsyData:function(){
     let that=this;
     wx.request({
       url: 'http://localhost:8080/bookstore_category_fantsy',
       success:function(res){
          that.setData({
            fantsy:res.data
          })
       }
     })
  },

    /**
     * getCityData use for get city book
     * 
     */
  getCityData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_city',
      success: function (res) {
        that.setData({
          city: res.data
        })
      }
    })
  },

  /**
 * getSelfcultivationData use for get self-cultivation book
 */
  getSelfcultivationData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_self-cultivation',
      success: function (res) {
        that.setData({
          selfcultivation: res.data
        })
      }
    })
  },


  /**
* getGirlData use for get girl book
*/
  getGirlData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_girl',
      success: function (res) {
        that.setData({
          girl: res.data
        })
      }
    })
  },

  /**
* getCrossingData use for get crossing book
*/
  getCrossingData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_crossing',
      success: function (res) {
        that.setData({
          crossing: res.data
        })
      }
    })
  },


  /**
* getOnlinegameData use for get onlinegame book
*/
  getOnlinegameData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_online-game',
      success: function (res) {
        that.setData({
          onlinegame: res.data
        })
      }
    })
  },


  /**
* getScifiData use for get scifi book
*/
  getScifiData: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/bookstore_category_sci-fi',
      success: function (res) {
        that.setData({
          scifi: res.data
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

  fantsytap:function(event){
    console.log(event.target.dataset.index)
  }
})