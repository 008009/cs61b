public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(p.yyPos-this.yyPos, 2) + Math.pow(p.xxPos - this.xxPos, 2));
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10,-11);
        return G*(this.mass)*(p.mass)/Math.pow(this.calcDistance(p),2);
    }

    public double calcForceExertedByX(Planet p) {
        return (this.calcForceExertedBy(p)*(p.xxPos-this.xxPos))/this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p) {
        return (this.calcForceExertedBy(p)*(p.yyPos-this.yyPos))/this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] P) {
        double result = 0;
        for(int i =0; i < P.length; i++) {
            if(this.equals(P[i])) {
                continue;
            }
            else {
                result += this.calcForceExertedByX(P[i]);
            }
        }
        return result;

    }
    public double calcNetForceExertedByY(Planet[] P) {
        double result = 0;
        for(int i =0; i < P.length; i++) {
            if(this.equals(P[i])) {
                continue;
            }
            else {
                result += this.calcForceExertedByY(P[i]);
            }
        }
        return result;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx/this.mass;
        double ay = fy/this.mass;
        this.xxVel= this.xxVel + (dt*ax);
        this.yyVel = this.yyVel + (dt*ay);
        this.xxPos = this.xxPos + dt*xxVel;
        this.yyPos = this.yyPos + dt*yyVel;
    }

    public void draw(){
        String img = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, img);
    }

}