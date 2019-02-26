import java.util.Scanner;
public class Marubatsu {
		//Scannerはforの外で　turn%2+1 0=" ",1="◯”,2="X"
		//do while復習。「whileの条件に当てはまる場合のみループする」
		//「同じマークの数＝マスの数」なら勝利する
		//
		public static void main(String[] args) {

			int koma = 3;
			int masu[][] = new int[koma][koma];
			//koma = magic number
			for(int i=0;i<koma;i++) {
				for(int y=0;y<koma;y++) {
					masu[i][y] = 0;
				}
			}
			String sign[] = {" ","◯","×"};
			//0="空白",1="◯",2="×"
			Scanner sc = new Scanner(System.in);
			//Scannerはfor文の外で
			for(int turn=0; turn<koma*koma; turn++) {
			//turn<9(0~8)
				int player = turn%2+1;
				System.out.print("プレイヤー"+player+"のターンです。");
			//置く場所を決める↓
				int putX,putY;
				do{
					System.out.println("X座標は？");
					putX = sc.nextInt();
					System.out.println("Y座標は？");
					putY = sc.nextInt();
				}while(putX<0||putY<0||putX>=koma||putY>=koma||masu[putX][putY]!=0);
			//置けない条件whileに当てはまるとdoに戻る↑  !=0の条件は「マスが空でない」　
				masu[putX][putY] = player;
			//player=1か2

			//丸かバツを置く
			for(int i=0;i<koma;i++) {
				String game = "|";
				for(int y=0;y<koma;y++) {
					game+=sign[masu[i][y]]+"|";
				}
				System.out.println(game);
			}
//縦にそろった時↓
			int judge = 0;
			for(int i=0; i<koma; i++) {
				if(masu[i][putY] == player)judge++;
			}
			if(judge==koma)win(player);
//横
			judge = 0;
			for(int y=0; y<koma; y++) {
				if(masu[putX][y] == player)judge++;
			}
			if(judge==koma)win(player);
//斜め１
//セル(0,0)(1,1)(2,2)の全てををどちらかが埋めた時winへ移行。
			judge = 0;
			for(int x=0; x<koma; x++) {
				if(masu[x][x] == player)judge++;
			}
			if(judge==koma)win(player);
//斜め２
//koma=3を代入し、セル(0,2)(1,1)(2,0)の全てををどちらかが埋めた時winへ移行。
			judge = 0;
			for(int x=0; x<koma; x++) {
				if(masu[x][koma-1-x] == player)judge++;
			}
			if(judge==koma)win(player);
		}
		System.out.println("引き分けです。");
	}
	public static void win(int player) {
		System.out.println("プレイヤー"+player+"の勝ちです！");
		System.exit(0);
	}
}



