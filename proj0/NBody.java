public class NBody {
    public static double readRadius(String s){
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] P = new Planet[N];
        int i = 0;
        while(i < N) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            P[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            i++;
            //System.out.println(P[i]);
        }
        return P;
    }

    public static void main(String [] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double R = readRadius("./data/planets.txt");
        Planet [] P = readPlanets("./data/planets.txt");
        StdDraw.setScale(-R,R);
        StdDraw.clear();
        StdDraw.picture(0,0,"./images/starfield.jpg");
        int N = P.length;
        for(int i=0; i < N; i++) {
            P[i].draw();
        }
        double time = 0;
        StdAudio.play("audio/hip-hop.mid");
        while(time != T) {
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for (int i = 0; i < N; i++) {
                xForces[i] = P[i].calcNetForceExertedByX(P);
                yForces[i] = P[i].calcNetForceExertedByY(P);
            }
            for (int i = 0; i < N; i++) {
                P[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int i=0; i < N; i++) {
                P[i].draw();
            }
            StdDraw.show(10);
            time += dt;
        }
        StdOut.printf("%d\n", P.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < P.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    P[i].xxPos, P[i].yyPos, P[i].xxVel, P[i].yyVel, P[i].mass, P[i].imgFileName);
        }
    }

}
