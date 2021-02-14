package com.kosmo.veve;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.kosmo.veve.dto.GallaryBoard;
import com.kosmo.veve.dto.GallaryFile;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class F1_ViewPagerAdapter extends PagerAdapter {

    LayoutInflater inflater;
    public List<GallaryBoard> gbList;
    public List<GallaryFile> gfList;

    private Context context;

    public F1_ViewPagerAdapter(List<GallaryBoard> gb_List,List<GallaryFile> gf_List, Context context) {
        this.gbList = gb_List;
        this.gfList = gf_List;
        this.context = context;
    }


    @Override
    public int getCount() {
        return gfList == null ? 0 : gfList.size();
    }

    //아답터가 만들어낼 Page(View)객체를
    //생성하는 코드를 작성하는 메소드 (page를 만들어야 할때 자동으로 호출됨)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {//container는 ViewPager를 참조하는 매개변수
        //instantiateItem 한번이 한 페이지를 만듬.
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View page= inflater.inflate(R.layout.item_image,container,false);
        ImageView iv= page.findViewById(R.id.view_image);

        GallaryFile item = gfList.get(position);
        new DownloadFilesTask(item.getF_name(),iv).execute();
        container.addView(page);
        // 여기선 리턴한 View객체가 저 아래 isViewFromObject()메소드에 전달됨.
        return page;

    }

    private static class DownloadFilesTask extends AsyncTask<String,Void, Bitmap> {
        private String urlStr;
        private ImageView imageView;
        public List<GallaryBoard> gbList;
        public List<GallaryFile> gfList;

        private static HashMap<String, Bitmap> bitmapHash = new HashMap<String, Bitmap>();

        public DownloadFilesTask(String urlStr, ImageView imageView) {
            this.urlStr = urlStr;
            this.imageView = imageView;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... voids) {
            Bitmap bitmap = null;
            try {
                if (bitmapHash.containsKey(urlStr)) {
                    if(bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                        bitmap = null;
                    }
                }
                URL url = new URL(urlStr);
                bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                bitmapHash.put(urlStr,bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

                    imageView.setImageBitmap(bitmap);
                    imageView.invalidate();
        }

    }

    //Viewpager에서 제거해야할 page(View)를 제거할때 자동 실행되는 메소드 (page를 없애야할 상황만 알려주는 메소드)
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //Viewpager에서 해당하는 page객체를 제거
        container.removeView((View)object);

    }

    //위 instantiateItem()메소드가 실행된 후
    //리턴된 page(View)가 ViewPager에서 현재 보여질 아이템과 같은지 검증하는 메소드
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {// view는 현재 보여질 페이지, object는 내가  return page;
        return view==object;    //이 값이 true여야 화면에 보인다.
    }
}
