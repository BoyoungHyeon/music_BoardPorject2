package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.MusicDAO2;

public class MusicManager2 {
	
	public void musicAllData2() {
		MusicDAO2 dao=new MusicDAO2();
		try {
			int k=1;
			for (int i = 1; i <= 3; i+=50) {
				Document doc = Jsoup.connect("https://www.melon.com/genre/song_list.htm?gnrCode=GN0800#params%5BgnrCode%5D=GN0800&params%5BdtlGnrCode%5D=&params%5BorderBy%5D=NEW&params%5BsteadyYn%5D=N&po=pageObj&startIndex=" + i).get();
				Elements title = doc.select("div.rank01");
				Elements singer = doc.select("div.rank02 span.checkEllipsis");
				Elements album = doc.select("div.rank03");
				Elements poster = doc.select("td a img");
	

				for (int j = 0; j < title.size(); j++) {
					try {
						MusicVO2 vo = new MusicVO2();
						System.out.println("번호 :"+k++);
						System.out.println("cateno:8");
						System.out.println("제목:" + title.get(j).text());
						System.out.println("가수명:" + singer.get(j).text());
						System.out.println("앨범:" + album.get(j).text());
						System.out.println("포스터:" + poster.get(j).attr("src"));
						System.out.println("=====================================");
						// vo에 값을 채운다 => DAO\
		
						vo.setCateno(8);
						vo.setTitle(title.get(j).text());
						vo.setSinger(singer.get(j).text());
						vo.setAlbum(album.get(j).text());
						vo.setPoster(poster.get(j).attr("src"));
						// DAO로 전송
						dao.musicInsert(vo);
						Thread.sleep(100);
					} catch (Exception ex) {}
				}
				System.out.println("End...");
			}
		} catch (Exception ex) {}
	}

	public static void main(String[] args) {
		MusicManager2 m=new MusicManager2();
		m.musicAllData2();
	}
}

