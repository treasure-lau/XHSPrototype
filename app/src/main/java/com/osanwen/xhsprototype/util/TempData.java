package com.osanwen.xhsprototype.util;

import com.osanwen.xhsprototype.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 临时数据
 * Created by liusaibao on 27/07/2017.
 */

public class TempData {
    public String text1;
    public String text2;
    public int drawableResId;

    public static List<TempData> getPager() {
        Integer[] drawableResIds = {R.drawable.default_image, R.drawable.default_image, R.drawable.default_image};
        List<TempData> dataList = new ArrayList<>();
        for (Integer drawableResId : drawableResIds) {
            TempData data = new TempData();
            data.drawableResId = drawableResId;
            dataList.add(data);
        }
        return dataList;
    }

    public static List<TempData> getVideo() {
        Integer[] drawableResIds = {R.drawable.default_image, R.drawable.default_image, R.drawable.default_image};
        List<TempData> dataList = new ArrayList<>();
        for (Integer drawableResId : drawableResIds) {
            TempData data = new TempData();
            data.drawableResId = drawableResId;
            data.text1 = "6109";
            data.text2 = "笑死了";
            dataList.add(data);
        }
        return dataList;
    }

    public static List<TempData> getNote() {
        Integer[] drawableResIds = {R.drawable.default_image, R.drawable.default_image, R.drawable.default_image};
        List<TempData> dataList = new ArrayList<>();
        for (Integer drawableResId : drawableResIds) {
            TempData data = new TempData();
            data.drawableResId = drawableResId;
            dataList.add(data);
        }
        return dataList;
    }

    public static List<TempData> getSearchResult() {
        String[] values = {"套装衣服", "宝宝衣服", "衣服搭配"};
        List<TempData> dataList = new ArrayList<>();
        for (String value : values) {
            TempData data = new TempData();
            data.text1 = value;
            dataList.add(data);
        }
        return dataList;
    }

    public static List<TempData> getData(int count) {
        TempData[] datas = new TempData[count];
        return Arrays.asList(datas);
    }

    public static List<TempData> getShareData() {
        Integer[] drawableResIds = {R.drawable.share_icon_weixin, R.drawable.share_icon_moment, R.drawable.share_icon_qq, R.drawable.xyvg_share_icon_link};
        String[] values = {"微信好友", "朋友圈", "QQ好友", "复制链接"};
        List<TempData> dataList = new ArrayList<>();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            TempData data = new TempData();
            data.drawableResId = drawableResIds[i];
            data.text1 = values[i];
            dataList.add(data);
        }
        return dataList;
    }
}
