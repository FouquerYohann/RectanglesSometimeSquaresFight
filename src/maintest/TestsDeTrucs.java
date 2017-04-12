package maintest;

public class TestsDeTrucs {

	public static void main(String[] args) {

		int w=10;
		int h=5;
		for (int i = 0; i < w * h; i++) {
			int x=i/h;
			int y=i%h;
			System.out.println("("+x+","+y+")");
		}
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				System.out.println("\t("+i+","+j+")");
			}
		}
	}

}
