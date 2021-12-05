package util;

public class Chrono {

    private long tempsDepart=0;
    private long tempsFin=0;
    private long pauseDepart=0;
    private long pauseFin=0;
    private long duree=0;

    public void start()
        {
        tempsDepart=System.currentTimeMillis();
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
        System.out.println("start");
        }

    public void pause()
        {
        if(tempsDepart==0) {return;}
        pauseDepart=System.currentTimeMillis();
        }

    public void resume()
        {
        if(tempsDepart==0) {return;}
        if(pauseDepart==0) {return;}
        pauseFin=System.currentTimeMillis();
        tempsDepart=tempsDepart+pauseFin-pauseDepart;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
        }
        
    public void stop()
        {
        if(tempsDepart==0) {return;}
        tempsFin=System.currentTimeMillis();
        duree=(tempsFin-tempsDepart) - (pauseFin-pauseDepart);
        tempsDepart=0;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        System.out.println("stop");
        }  
        
        //ATMMMMMMMMMMMMMMMMMMM
    public long getDureeMsATM() {
        return (System.currentTimeMillis()-tempsDepart) - (pauseFin-pauseDepart);
    }

    
    public String getDureeTxtATM()
        {
        return timeToHMSATM(getDureeMsATM());
        }
    
    public static String timeToHMSATM(long tempsS) {

         // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "3.15 s"
        int s = (int) ((tempsS / 1000) %60);
        int ms = (int) (tempsS - (s *1000) );
        ms = Math.round(ms /100);

        String r="";
    
        r+=s;
        //if(ms>0) {r+="."+ms;}
        if(s<=0 && ms<= 0) {r="0 s";}
    
        return r;

        }

        //FINNNNNNNNNNNNN
    public long getDureeSec()
        {
        return duree/1000;
        }
        
    public long getDureeMs()
        {
        return duree;
        } 
    
    public String getDureeTxt()
        {
        return timeToHMS(getDureeMs());
        }
    public static String timeToHMS(long tempsS) {
        int s = (int) ((tempsS / 1000) % 60);
        int ms = (int) (tempsS - (s *1000) );
        ms = Math.round(ms /10);

        
        String r="";

        if(s>0) {r+=s;}
        else    {r+="0";}
        if(ms>0) {r+="."+ms;}
        r+=" s";
        if(s<=0 && ms<= 0) {r="0 s";}

        return r;
        }

    }