package CrackingTheCodingInterview.ch5;

public class DrawHorizontalLine {
    public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int firstFullByte = x1 / 8;
        if (startOffset != 0) {
            firstFullByte++;
        }

        int endOffset = x2 % 8;
        int lastFullByte = x2 / 8;
        if (endOffset != 7) {
            lastFullByte--;
        }

        // 绘制中间的完整字节
        for (int b = firstFullByte; b <= lastFullByte; b++) {
            screen[(y * (width / 8)) + b] = (byte) 0xFF;
        }

        // 创建开始和结束的掩码
        byte startMask = (byte) (0xFF >> startOffset);
        byte endMask = (byte) ~(0xFF >> (endOffset + 1));

        // 绘制开始和结束的字节
        if ((x1 / 8) == (x2 / 8)) {
            byte mask = (byte) (startMask & endMask);
            screen[(y * (width / 8)) + (x1 / 8)] |= mask;
        } else {
            if (startOffset != 0) {
                int byteNumber = (y * (width / 8)) + firstFullByte - 1;
                screen[byteNumber] |= startMask;
            }
            if (endOffset != 7) {
                int byteNumber = (y * (width / 8)) + lastFullByte + 1;
                screen[byteNumber] |= endMask;
            }
        }
    }

    public static void main(String[] args) {
        int width = 32;
        byte[] screen = new byte[width * 1 / 8]; // 假设高度为 1
        int x1 = 2;
        int x2 = 29;
        int y = 0;

        drawHorizontalLine(screen, width, x1, x2, y);

        // 打印结果
        for (int i = 0; i < screen.length; i++) {
            System.out.print(String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0') + " ");
        }
    }
}    