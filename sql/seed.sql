use sukesyunshopdb;

DELETE FROM user_info;
INSERT INTO user_info(
user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email
)VALUES(
"taro" , "123", "山田", "太郎", "やまだ", "たろう", 0, "taro@gmail.com"
),(
"jiro123" , "123", "山中", "次郎", "やまなか", "じろう", 0, "jiro@gmail.com"
),(
"hanako" , "123", "山野", "花子", "やまの", "はなこ", 1, "hanako@gmail.com"
),(
"hoge" , "hoge", "ほげ山", "ほげ男", "ほげやま", "ほげお",0, "hoge@gmail.com"
),(
"john" , "1john", "john", "smith", "じょん", "すみす", 1, "john@gmail.com"
);

DELETE FROM m_category;
INSERT INTO m_category(
category_id, category_name, category_description
) VALUES (
1001 , "音響機器", "音響機器です。"
),(
1002 , "PC周辺機器", "PC周辺です。"
),(
1003 , "家電機器" , "家電機器です。"
),(
1004 , "DVD&Blu-ray","DVD&Blu-rayです。"
),(
1005 , "ファッション&小物", "ファッションと小物です。"
),(
1006 , "TVゲーム", "TVゲームです。"
);



DELETE FROM product_info;
INSERT INTO product_info(
product_id, product_name, product_name_kana, product_description, category_id, price, image_file_path, image_file_name, release_date, release_company
) VALUES (
1 , "すごいマイク", "すごいまいく", "なんだかわからないけどとにかくすごいマイク。", 1001, 10000, "./public/1.jpg", "1.jpg", "2017-05-05 15:15:15", "すごい会社"
),(
2 , "よいスピーカー", "よいすぴーかー", "なんとなくよい。", 1001, 1500, "./public/2.jpg", "2.jpg", "2017-05-06 15:15:15", "よい会社"
),(
3 , "だめなアンプ", "だめなあんぷ", "なにもかもがだめだめ。", 1001, 1, "./public/3.jpg", "3jpg", "2017-05-07 15:15:15", "悪い会社"
),(
4 , "軽い携帯音楽プレーヤー", "かるいけいたいおんがくぷれーやー", "重さ三グラム。", 1001, 5000, "./public/4.jpg", "4.jpg", "2017-05-08 15:15:15", "よい会社"
),(
5 , "何でも聞こえるヘッドフォン", "なんでもきこえるへっどふぉん", "きこえないものまできこえます。", 1001, 90000, "./public/5.jpg", "5.jpg", "2017-05-09 15:15:15", "すごい会社"
),(
6 , "見やすいモニター", "みやすいもにたー", "ブルーライトカットです。", 1002, 15000, "./public/6.jpg", "6.jpg", "2017-05-10 15:15:15", "すごい会社"
),(
7 , "キーボード", "キーボード", "打ちやすいキーボードです。", 1002, 5000, "./public/7.jpg", "7.jpg", "2017-05-12 15:15:15", "すごい会社"
),(
8 , "マウス", "まうす", "かちかちが楽しいです。", 1002, 5000, "./public/8.jpg", "8.jpg", "2017-05-13 15:15:15", "よい会社"
),(
9 , "HDMIケーブル", "えいちでぃーえむあいけーぶる", "何かと使えるケーブルです。", 1002, 5000, "./public/9.jpg", "9.jpg", "2017-05-14 15:15:15", "悪い会社"
),(
10 , "プリンター", "ぷりんたー", "スキャナーにも使えます。", 1002, 5000, "./public/10.jpg", "10.jpg", "2017-05-15 15:15:15", "すごい会社"
),(
11 , "3GBのUSB", "ゆーえすびー", "ある程度なら入ります。", 1002, 5000, "./public/11.jpg", "11.jpg", "2017-05-16 15:15:15", "よい会社"
),(
12 , "アナと雪の…", "あなとゆきのじょうおう", "大ヒットの映画です。", 1004, 5000, "./public/12.jpg", "12.jpg", "2017-05-17 15:15:15", "よい会社"
),(
13 , "ダイハード", "だいはーど", "ついてない男のお話", 1004, 5000, "./public/13.jpg", "13.jpg", "2017-05-18 15:15:15", "悪い会社"
),(
14 , "ワンパンマン", "わんぱんまん", "何もかもワンパンでなぎ倒す", 1004, 5000, "./public/14.jpg", "14.jpg", "2017-05-19 15:15:15", "よい会社"
),(
15 , "デジモン", "でじもん", "デジタルモンスター縮めてでじもん", 1004, 5000, "./public/15.jpg", "15.jpg", "2017-05-20 15:15:15", "すごい会社"
),(
16 , "笑ってはいけない24時", "わらってはいけないにじゅうよじ", "年末恒例のやつの総集編", 1004, 5000, "./public/16.jpg", "16.jpg", "2017-05-21 15:15:15", "すごい会社"
),(
17 , "ドラえもん", "どらえもん", "有名な青い狸です", 1004, 5000, "./public/17.jpg", "17.jpg", "2017-05-22 15:15:15", "悪い会社"
),(
18 , "アイアンマン", "あいあんまん", "悪を滅ぼす正義のヒーロー", 1004, 5000, "./public/18.jpg", "18.jpg", "2017-05-23 15:15:15", "よい会社"
),(
19 , "妖怪ウォッチ", "ようかいうぉっち", "ようかい体操第一！", 1004, 5000, "./public/19.jpg", "19.jpg", "2017-05-24 15:15:15", "すごい会社"
),(
20 , "アンパンマン", "あんぱんまん", "今日もアンパンマンはパトロールに行きます。", 1004, 5000, "./public/20.jpg", "20.jpg", "2017-05-25 15:15:15", "よい会社"
),(
21 , "警察24時", "けいさつにじゅうよじ", "テレビでやっていたものの総集編", 1004, 5000, "./public/21.jpg", "21.jpg", "2017-05-26 15:15:15", "悪い会社"
),(
22 , "半そでTシャツ", "はんそでてぃーしゃつ", "はんそでのTシャツです。", 1005, 5000, "./public/22.jpg", "22.jpg", "2017-05-27 15:15:15", "すごい会社"
),(
23 , "ジーパン", "じーぱん", "デニム地のパンツです。", 1005, 5000, "./public/23.jpg", "23.jpg", "2017-05-28 15:15:15", "よい会社"
),(
24 , "派手なパンツ", "はでなぱんつ", "カラフルで目に悪いパンツです。", 1005, 5000, "./public/24.jpg", "24.jpg", "2017-05-29 15:15:15", "すごい会社"
),(
25 , "浴衣", "ゆかた", "夏祭りの必需品です。", 1005, 5000, "./public/25.jpg", "25.jpg", "2017-06-05 15:15:15", "よい会社"
),(
26 , "チェスターコート", "ちぇすたーこーと", "あったかくなれます。", 1005, 5000, "./public/26.jpg", "26.jpg", "2017-07-05 15:15:15", "悪い会社"
),(
27 , "安い水着", "やすいみずぎ", "やすいのに長持ちします。", 1005, 5000, "./public/27.jpg", "27.jpg", "2017-08-05 15:15:15", "すごい会社"
),(
28 , "空も飛べる靴", "そらもとべるくつ", "空を飛ぶことができそうなくつです。", 1005, 5000, "./public/28.jpg", "28.jpg", "2017-09-05 15:15:15", "よい会社"
),(
29 , "なんでも入るバック", "なんでもはいるばっく", "ある程度ならなんでも入ります。", 1005, 5000, "./public/29.jpg", "29.jpg", "2017-10-05 15:15:15", "すごい会社"
),(
30 , "お金がなくなる財布", "おかねがなくなるさいふ", "気付いたらお金がなくなる魔法の財布です。", 1005, 5000, "./public/30.jpg", "30.jpg", "2017-11-05 15:15:15", "悪い会社"
),(
31 , "時間の狂わない時計", "じかんのくるわないとけい", "何があっても時間が狂いません。", 1005, 5000, "./public/31.jpg", "31.jpg", "2017-12-05 15:15:15", "よい会社"
),(
32 , "感染症にかかるピアス", "かんせんしょうにかかるぴあす", "昔誰かの使っていたピアスです。", 1005, 5000, "./public/32.jpg", "32.jpg", "2013-05-05 15:15:15", "悪い会社"
),(
33 , "みんなから尊敬されるネックレス", "みんなからそんけいされるねっくれす", "つけるだけで皆から尊敬されます", 1005, 5000, "./public/33.jpg", "33.jpg", "2014-05-05 15:15:15", "すごい会社"
),(
34 , "安いペンダント", "やすいぺんだんと", "とりあえず価格を見てください。", 1005, 5000, "./public/34.jpg", "34.jpg", "2015-05-05 15:15:15", "よい会社"
),(
35 , "モンスターハンター", "もんすたーはんたー", "最新作のワールドです", 1006, 5000, "./public/35.jpg", "35.jpg", "2016-05-05 15:15:15", "すごい会社"
),(
36 , "ドラクエ", "どらくえ", "ドラゴンクエスト12先行発売！！", 1006, 5000, "./public/36.jpg", "36.jpg", "2011-05-05 15:15:15", "悪い会社"
),(
37 , "goat simulator", "ごーとしみゅれーたー", "やぎが町で暴れまわります。", 1006, 5000, "./public/37.jpg", "37.jpg", "2017-05-05 15:15:11", "すごい会社"
),(
38 , "flappy bird", "ふらっぴーばーど", "鳥が飛んだり跳ねたりします", 1006, 5000, "./public/38.jpg", "38.jpg", "2017-05-05 15:15:12", "すごい会社"
),(
39 , "COD WW2", "しーおーでぃーわーるどうぉーつー", "CODシリーズの最新作です。", 1006, 5000, "./public/39.jpg", "39.jpg", "2017-05-05 15:15:13", "すごい会社"
),(
40 , "人生ゲーム", "じんせいげーむ", "過去最長級の人生ゲームです。", 1006, 5000, "./public/40.jpg", "40.jpg", "2017-05-05 15:15:14", "すごい会社"
),(
41 , "テトリス", "てとりす", "奥の深いゲームです。", 1006, 5000, "./public/41.jpg", "41.jpg", "2017-05-05 15:15:16", "すごい会社"
),(
42 , "F1 2017", "えふわん　にせんじゅうなな", "F1をゲームで楽しみましょう。", 1006, 5000, "./public/42.jpg", "42.jpg", "2017-05-05 15:15:17", "すごい会社"
),(
43 , "高性能炊飯器", "こうせいのうすいはんき", "自然な白米の味をお届けします。", 1003,8000, "./public/43.jpg", "43.jpg", "2017-05-05 15:15:18", "すごい会社"
),(
44 , "オーブンレンジ", "おーぶんれんじ", "簡単な料理ならチンするだけで作れます。", 1003, 10000, "./public/44.jpg", "44.jpg", "2017-05-05 15:15:19", "すごい会社"
),(
45 , "おしゃれな冷蔵庫", "おしゃれなれいぞうこ", "デザインと機能を両立しています。", 1003, 20000, "./public/45.jpg", "45.jpg", "2017-05-05 15:11:15", "すごい会社"
),(
46 , "高性能洗濯機", "こうせいのうせんたくき", "衣類に限らず食器なども洗えます。", 1003, 30000, "./public/46.jpg", "46.jpg", "2017-05-05 15:12:15", "すごい会社"
);