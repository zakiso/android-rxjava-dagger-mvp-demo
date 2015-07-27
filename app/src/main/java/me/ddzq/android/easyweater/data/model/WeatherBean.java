package me.ddzq.android.easyweater.data.model;

/**
 * Created by dzq on 15/7/25.
 */
public class WeatherBean {

    /**
     * 天气的数据模型
     * errNum : 0
     * errMsg : success
     * retData : {"date":"15-07-25","altitude":"33","temp":"33","sunrise":"05:06","city":"北京","h_tmp":"33","latitude":39.904,"WD":"无持续风向","pinyin":"beijing","citycode":"101010100","sunset":"19:35","weather":"多云","postCode":"100000","l_tmp":"23","time":"11:00","WS":"微风(<10m/h)","longitude":116.391}
     */
    private int errNum;
    private String errMsg;
    private RetDataEntity retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public static class RetDataEntity {
        /**
         * date : 15-07-25
         * altitude : 33
         * temp : 33
         * sunrise : 05:06
         * city : 北京
         * h_tmp : 33
         * latitude : 39.904
         * WD : 无持续风向
         * pinyin : beijing
         * citycode : 101010100
         * sunset : 19:35
         * weather : 多云
         * postCode : 100000
         * l_tmp : 23
         * time : 11:00
         * WS : 微风(<10m/h)
         * longitude : 116.391
         */
        private String date;
        private String altitude;
        private String temp;
        private String sunrise;
        private String city;
        private String h_tmp;
        private double latitude;
        private String WD;
        private String pinyin;
        private String citycode;
        private String sunset;
        private String weather;
        private String postCode;
        private String l_tmp;
        private String time;
        private String WS;
        private double longitude;

        public void setDate(String date) {
            this.date = date;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setH_tmp(String h_tmp) {
            this.h_tmp = h_tmp;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public void setL_tmp(String l_tmp) {
            this.l_tmp = l_tmp;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getDate() {
            return date;
        }

        public String getAltitude() {
            return altitude;
        }

        public String getTemp() {
            return temp;
        }

        public String getSunrise() {
            return sunrise;
        }

        public String getCity() {
            return city;
        }

        public String getH_tmp() {
            return h_tmp;
        }

        public double getLatitude() {
            return latitude;
        }

        public String getWD() {
            return WD;
        }

        public String getPinyin() {
            return pinyin;
        }

        public String getCitycode() {
            return citycode;
        }

        public String getSunset() {
            return sunset;
        }

        public String getWeather() {
            return weather;
        }

        public String getPostCode() {
            return postCode;
        }

        public String getL_tmp() {
            return l_tmp;
        }

        public String getTime() {
            return time;
        }

        public String getWS() {
            return WS;
        }

        public double getLongitude() {
            return longitude;
        }
    }


    @Override
    public String toString() {

        if (retData != null) {
            return "日期:" + retData.getDate() + "\n" +
                    "城市:" + retData.getCity() + '\n' +
                    "天气:" + retData.getWeather() + '\n' +
                    "最高温度:" + retData.getH_tmp() + '\n' +
                    "最低温度:" + retData.getL_tmp();
        }

        return "WeatherBean{" +
                "errNum=" + errNum +
                ", errMsg='" + errMsg + '\'' +
                ", retData=" + retData +
                '}';
    }
}
