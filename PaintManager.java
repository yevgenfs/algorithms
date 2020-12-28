package secondLabPaint;

public class PaintManager {

	public void paintingTime(int mas[], int timeOfPaintInMinutes, int quantityOfPainter) {
		if (quantityOfPainter >= mas.length) {
			int sumOfTime = 0;
			int key = mas[0];
			for (int i = 0; i < mas.length - 1; i++) {
				if (mas[i] < mas[i + 1]) {
					key = mas[i + 1];
				}
			}
			sumOfTime = key * timeOfPaintInMinutes;
			System.out.println(sumOfTime);
		} else if (quantityOfPainter < mas.length) {
			PaintManager painter = new PaintManager();
			int sumOfTime = 0;
			int devidedLenght = (mas.length / quantityOfPainter);
			int firstSum = 0;
			int secondSum = 0;
			int index=0;
			for (int i = 0; i < quantityOfPainter; i++) {
				index=0;
				for (int j = devidedLenght * (i); j < devidedLenght * (i + 1); j++) {
					secondSum += mas[j];
					if (mas.length % 2 == 1 && j == devidedLenght * (i + 1) - 1) {
						secondSum += mas[j + 1];
					}

				}

				if (firstSum == 0) {
					firstSum = secondSum;
				}
				if (firstSum > secondSum / 0.9) {

					painter.left( firstSum, secondSum,   mas , timeOfPaintInMinutes , sumOfTime,  devidedLenght , i ,index);
					
				} else if (firstSum / 0.9 < secondSum) {
					painter.right( firstSum, secondSum,   mas , timeOfPaintInMinutes , sumOfTime,  devidedLenght , i ,index);

				} else {
					firstSum *= timeOfPaintInMinutes;
					if (firstSum > sumOfTime) {
						sumOfTime = firstSum;

					}
					firstSum = secondSum;
					secondSum = 0;
				}
				firstSum=secondSum;
				if (i == quantityOfPainter - 1) {
					if (firstSum * timeOfPaintInMinutes > sumOfTime) {
						sumOfTime = firstSum * timeOfPaintInMinutes;

					}
				}

			}
			System.out.println("time " + sumOfTime);
		}
	}
		
		public void left(int firstSum,int secondSum, int [] mas ,int timeOfPaintInMinutes ,int sumOfTime, int devidedLenght ,int i ,int index ) {
			
			if (firstSum > secondSum / 0.9) {
				PaintManager painters = new PaintManager();
				firstSum -= mas[(devidedLenght * i)-index];
				firstSum *= timeOfPaintInMinutes;
				index++;
				if (firstSum > sumOfTime) {
					sumOfTime = firstSum;
					
				}
				secondSum += mas[(devidedLenght * i)-index];
				

				secondSum = 0;
				index++;
				painters.left( firstSum, secondSum,   mas , timeOfPaintInMinutes , sumOfTime,  devidedLenght , i ,index );
			}
	
	}
		
		public void right(int firstSum,int secondSum, int [] mas ,int timeOfPaintInMinutes ,int sumOfTime, int devidedLenght ,int i ,int index ) {
			 if (firstSum / 0.9 < secondSum) {
				 PaintManager painters = new PaintManager();
				firstSum += mas[(devidedLenght * i)-index];

				firstSum *= timeOfPaintInMinutes;

				if (firstSum > sumOfTime) {
					sumOfTime = firstSum;

				}
				secondSum -= mas[(devidedLenght * i)-index];
				

				secondSum = 0;
				index--;
				 painters.right( firstSum, secondSum,   mas , timeOfPaintInMinutes , sumOfTime,  devidedLenght , i,index );
			} 
			
		}

	public static void main(String[] args) {
		int[] mas = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int timeOfPaintInMinutes = 5;
		int quantityOfpainters = 4;
		PaintManager paint = new PaintManager();
		paint.paintingTime(mas, timeOfPaintInMinutes, quantityOfpainters);
	}
}
