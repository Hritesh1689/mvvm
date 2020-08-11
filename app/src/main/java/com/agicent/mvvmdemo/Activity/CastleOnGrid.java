package com.agicent.mvvmdemo.Activity;

import java.io.*;
import java.util.*;

public class CastleOnGrid {

//    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
//       String[][] castles=new String[grid.length][grid.length];
//       for(int i=0;i<grid.length;i++){
//           for(int j=0;j<grid.length;j++) {
//               castles[i][j] = grid[i].split("")[j];
//           }
//       }
//
//       ArrayList<Path> totalAvailablePaths=new ArrayList<>();
//       totalAvailablePaths.add(new Path(new LinkedList<>(Arrays.asList(new Position(startX,startY))),"NoSide"));
//
//       while(totalAvailablePaths.size()!=0){
//           Path currentNode=totalAvailablePaths.get(totalAvailablePaths.size()-1);
//           totalAvailablePaths.remove(totalAvailablePaths.size()-1);
//           int x=currentNode.root.getLast().x;
//           int y=currentNode.root.getLast().y;
//           String direction=currentNode.direction;
//                              LinkedList<Position> paths=new LinkedList<>(currentNode.root);
//                              totalAvailablePaths.clear();
//           if(x==0){
//               if(direction.equals("upar")){
//               if(castles[x][y+1].equals(".")) {
//                   paths.add(new Position(x,y+1));
//                   totalAvailablePaths.add(new Path(paths,"aage"));
//               }}
//               else if(direction.equals("peeche"))
//               {
//                   if(castles[x+1][y].equals(".")) {
//                       paths.add(new Position(x+1,y));
//                       totalAvailablePaths.add(new Path(paths,"neeche"));
//                   }
//               }else{
//                   paths.add(new Position(x,y+1));
//                   totalAvailablePaths.add(new Path(paths,"aage"));
//                   paths.add(new Position(x+1,y));
//                   totalAvailablePaths.add(new Path(paths,"neeche"));
//               }
//           }else if(x==grid.length-1){
//
//
//           }else if(y==0){
//
//           }else if(y==grid.length-1){
//
//           }
//       }
//
//
//
//        return 0;
//    }
//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String[] grid = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            String gridItem = scanner.nextLine();
//            grid[i] = gridItem;
//        }
//
//        String[] startXStartY = scanner.nextLine().split(" ");
//
//        int startX = Integer.parseInt(startXStartY[0]);
//
//        int startY = Integer.parseInt(startXStartY[1]);
//
//        int goalX = Integer.parseInt(startXStartY[2]);
//
//        int goalY = Integer.parseInt(startXStartY[3]);
//
//        int result = minimumMoves(grid, startX, startY, goalX, goalY);
//
//
//        System.out.println(result);
////        bufferedWriter.write(String.valueOf(result));
////        bufferedWriter.newLine();
////
////        bufferedWriter.close();
//
//        scanner.close();
        int[] jool=new int[1000];
        System.out.println(jool[4]);
    }


//
//  static class Path{
//        LinkedList<Position> root;
//        String direction;
//
//        //ArrayList<ArrayList<Integer>> pathNodes=new ArrayList<>();
//
//      Path( LinkedList<Position> root,String direction){
//          this.root=root;
//           this.direction=direction;
//        }
//
//    }
//
//    static class Position{
//        int x;
//        int y;
//
//        Position(int x,int y){
//            this.x=x;
//            this.y=y;
//        }
//    }





    static int downToZero(int n) {
        /*
         * Write your code here.
         */
        int tohelp=n;
        int minmov=0;
        while(n!=0){
            boolean foundAnyDivisor=false;
            int minDiv=Integer.MAX_VALUE;
            for(int i=2;i<=n/2;i++){
               // if(n!=i) {
                    if (n % i == 0) {
                        tohelp = Math.max(i, n / i);
                        if(tohelp<minDiv)
                            minDiv=tohelp;
                        foundAnyDivisor = true;
                    }
               // }
            }

            if(!foundAnyDivisor)
                n=n-1;
            else
                n=minDiv;

            minmov++;

        }
        return minmov;
    }

}
