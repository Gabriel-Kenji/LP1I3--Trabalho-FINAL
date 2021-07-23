import java.util.Scanner;
import java.text.DateFormat;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

class Hora {
    
    Scanner ler = new Scanner(System.in);
    private int hora;
    private int min;
    private int seg;
    
    public Hora() {
        
        setHora();
        setMin();
        setSeg();
        //System.out.println("Horario AM/PM: "+getHora2());
        //System.out.println("Horario: "+getHora1());
        //System.out.println("Quantidade de segundos: "+getSegundos());

    }
    
    public Hora(int h, int m, int s){
        
        this.hora = h;
        this.min = m;
        this.seg = s;
       
    }
    
    public void setHora(int h){
        this.hora = h;
    }
    
    public void setMin(int m){
        this.min = m;
    }
    
    public void setSeg(int s){
        this.seg = s;
    }
    
    public void setHora(){
        
        do {
            System.out.print("Digite a hora: ");
            hora = ler.nextInt(); 
            } while (hora > 24 || hora < 1);       
    }
    
    public void setMin(){
        
        do {	
            System.out.print("Digite os minutos: ");
            min = ler.nextInt();
            } while (min > 59 || min < 0);
    }
    
    public void setSeg(){
        
        do {
            System.out.print("Digite os segundos: ");
            seg = ler.nextInt();
            } while (seg > 59 || seg < 0);
    }
    
    public int getHora(int hora){
        return hora;
    }
    
    public int getMin(int min){
        return min;
    }
    
    public int getSeg(int seg){
        return seg;
    }
    
    public String getHora1(){
        
        if(this.hora == 24)
        {
            String A = ("00:"+this.min+":"+this.seg);
            return A;
        }
        else
        {
          String A = (this.hora+":"+this.min+":"+this.seg);
          return A;
        }
        
    }
    
    public String getHora2(){
        
        String hora;
        String min;
        String seg;
        String periodo;
        int hora2;
        
        if(this.hora > 12)
        {
            hora2 = this.hora - 12;
        }
        else 
        {
            hora2 = this.hora;
        }
        if(hora2 < 10)
        {
            hora = "0"+hora2;
        }
        else
        {
            hora = ""+hora2;
        }
        
        if(this.min < 10)
            {
                min = "0"+this.min;
            }
        else
            {
                min = ""+this.min;
            }
        if(this.seg < 10)
            {
                seg = "0"+this.seg;
            }
        else 
            {
                seg = ""+this.seg;
            }
        if(this.hora < 12)
            {                    
                periodo = "AM";
            }
        else
            {
                
                periodo = "PM";
            }
    
    return hora+":"+min+":"+seg+"("+periodo+")";
        
    }
    
    public int getSegundos(){
        
        int calcH = hora * 3600;
        int calcM = min * 60;		
        int horario = seg + calcH + calcM;    
        return horario;
    }
}

class Data {

    Scanner ler = new Scanner(System.in);

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        setAno();
        setAno(ano);
        setMes();
        setMes(mes);
        setDia();
        setDia(dia);
        
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia(int d) {
        this.dia = d;
    }

    public void setMes(int m) {
        this.mes = m;
    }

    public void setAno(int a) {
        this.ano = a;
    }

    public void setDia() {
        boolean bissexto = bissexto();
        System.out.print("Digite o dia: ");
        this.dia = ler.nextInt();
        while (this.dia > 31 || this.dia < 1) {

            System.out.print("Digite o dia: ");
            this.dia = ler.nextInt();
            
        }
        while(this.dia > 30 && (this.mes == 2 || this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11)){

            System.out.print("Dia informado nao existe no mes / ano informados\nInforme o dia: ");
            this.dia = ler.nextInt();    
        }

        while(this.dia > 28 && this.mes == 2 && bissexto == false){
           
            System.out.print("Dia informado nao existe no mes / ano informados\nInforme o dia: ");
            this.dia = ler.nextInt();
        }

        while(this.dia > 29 && this.mes == 2 && bissexto == true){
           
            System.out.print("Dia informado nao existe no mes / ano informados\nInforme o dia: ");
            this.dia = ler.nextInt();
        }
    }

    public void setMes() { 
        System.out.print("Informe o mes: ");
        this.mes = ler.nextInt();
        while (this.mes > 12 || this.mes < 1) {
            System.out.print("Informe o mes: ");
            this.mes = ler.nextInt();
        }    
    }

    public void setAno() {
        System.out.print("Informe o ano: ");
        this.ano = ler.nextInt();
        while (this.ano < 0) {
            System.out.print("Informe o ano: ");
            this.ano = ler.nextInt();
        }
    }

    public int getDia() {
        return (this.dia);
    }

    public int getMes() {
        return (this.mes);
    }

    public int getAno() {
        return (this.ano);
    }

    public void mostra1() {
        System.out.println(this.getDia() + "/" + this.getMes() + "/" + this.getAno());
    }

    public void mostra2() {
        String[]meses = {"Janeiro","Fevereiro", "Março", "Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        System.out.println(this.getDia() + "/" + meses[this.getMes() - 1] + "/" + this.getAno());
    }

    public boolean bissexto() {
        if(this.getAno() % 4 == 0){
            if(this.getAno() % 100 == 0){
                if(this.getAno() % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public int diasTranscorridos() {
        boolean bissexto = bissexto();
        int[] diasmes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int cont = 0;
        int total = 0;
        if(bissexto == true){
            while((cont + 1) < this.getMes()){
                total += diasmes[cont];
                cont++;
            }
            total += this.getDia();
            if(this.getMes()>=2){
                if(this.getMes()>2)
                {
                    total += 1;
                }
                else if(this.getDia()>28)
                {
                    total +=1;
                }
            }
            
        }
        else{
            while((cont + 1) < this.getMes()){
                total += diasmes[cont];
                cont++;
            }
            total += this.getDia();
        }
        return total;
    }
    void apresentaDataAtual(){
        Date d = new Date();
        DateFormat atual = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR"));
        System.out.println("\nData atual: " + atual.format(d));
    }
}

class ConsultaAgendada{

    Scanner ler = new Scanner(System.in);

    private Data data;
    private Hora hora;
    private String nomePaciente;
    private int quantidade;
    private String nomeMedico;      

    public ConsultaAgendada(){
        
        setData();
        setHora();
        setNomeMedico();
        setNomeMedico(nomeMedico);
        setNomePaciente();
        setNomePaciente(nomePaciente);
        System.out.println("\nDADOS CONSULTA\n");
		
		System.out.println(getData());
		System.out.println(getHora());
		System.out.println("Nome do medico: "+ getNomeMedico());
		System.out.println("Nome do paciente: "+ getNomePaciente());
		System.out.println("Quantidade: "+ getAmostra());
        System.out.println("\n|###########################################################|\n");
        
    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String np,String nm){
        this.hora = new Hora(h,mi,s);
		this.data = new Data(d, m, a);
        this.nomePaciente = np;
        this.nomeMedico = nm;
    }

    public ConsultaAgendada (Data d, Hora h, String np, String nm) {
		this.data = new Data();
		this.hora = new Hora();
		this.nomePaciente = np;
		this.nomeMedico = nm;
	}

    public void setData(int a, int b, int c) {
		this.data = new Data(a,b,c);
	}
    public void setData(){
     
        this.data = new Data();
    
        
    }
    public void setHora(int a, int b, int c) {
		this.hora = new Hora(a,b,c);
	}
	
	public void setHora() {
        this.hora = new Hora();
	}
	
	public void setNomePaciente(String p){
		this.nomePaciente = p;
	}
	
	public void setNomePaciente(){
        System.out.print("Digite o nome do paciente: ");
		this.nomePaciente = ler.next();
	}
	
	public void setNomeMedico(String m){
		this.nomeMedico = m;
	}
	
	public void setNomeMedico(){
        System.out.print("Digite o nome do medico: ");
		this.nomeMedico = ler.next();
	}
	
	public int getAmostra() {
		return ++this.quantidade;
	}
	
	public String getData() {
		return "Data: "+this.data.getDia() +"/"+this.data.getMes()+"/"+this.data.getAno();
	}
	
	public String getHora() {
		return "Horario: " +this.hora.getHora1();
	}
	
	public String getNomePaciente() {
		return this.nomePaciente;
	}
	
	public String getNomeMedico() {
		return this.nomeMedico;
	}

}

class TpFinalEx02{
    public static void main(String[] args) {
        // Datas data = new Datas();
        // Hora h = new Hora();

        Scanner ler = new Scanner(System.in);
		ConsultaAgendada p1 = new ConsultaAgendada(02, 10, 33, 23, 07, 2021, "Pedro", "Lucas");
		String s = "";
        String text;
        Path  p = Paths.get("./logfile.txt");  
        text ="Dados P1:\n";
        s = s + text ;
		System.out.print(text);
        text =  p1.getData() + "\n";
        s = s + text ;
		System.out.print(text);
        text =  p1.getHora() + "\n";
        s = s + text ;
		System.out.print(text);
        text ="Nome do medico: "+p1.getNomeMedico()+ "\n";
        s = s + text ;
		System.out.print(text);
        text ="Nome do paciente: "+p1.getNomePaciente()+ "\n";
        s = s + text ;
		System.out.print(text);
        text ="Quantidade de consultas: "+p1.getAmostra() + "\n";
        s = s + text ;
		System.out.print(text);
        text ="\n|###########################################################|\n";
        s = s + text ;
		System.out.print(text);

        
		

        text ="Dados P2:\n";
        s = s + text ;
		System.out.print(text);

        
		ConsultaAgendada p2 = new ConsultaAgendada();
        s = s + "\nDADOS CONSULTA\n\n";
        s = s + p2.getData() + "\n";
        s = s + p2.getHora() + "\n";
        s = s + "Nome do medico: "+ p2.getNomeMedico() + "\n";
		s = s + "Nome do paciente: "+ p2.getNomePaciente()+ "\n";
		s = s + "Quantidade: "+ p2.getAmostra()+ "\n";
        s = s + "\n|###########################################################|\n";

        text ="P1 alteracao:\n";
        s = s + text ;
		System.out.print(text);

        text ="Dados atual P1:\n\n";
        s = s + text ;
		System.out.print(text);
        text = p1.getData() + "\n";
        s = s + text ;
		System.out.print(text);
        text = p1.getHora() + "\n";
        s = s + text ;
		System.out.print(text);
        text = "Nome do medico: "+p1.getNomeMedico() + "\n";
        s = s + text ;
		System.out.print(text);
        text = "Nome do paciente: "+p1.getNomePaciente() + "\n";
        s = s + text ;
		System.out.print(text);

		
		text = "Dados P1 depois da alteracao:\n\n";
        s = s + text ;
		System.out.print(text);

		p1.setData(10, 10, 2020);
		p1.setHora(14, 7, 8);
		p1.setNomeMedico("Luiz");
		p1.setNomePaciente("Josevaldo");
		

		text = p1.getData() + "\n";
        s = s + text ;
		System.out.print(text);
		text = p1.getHora()+ "\n";
        s = s + text ;
		System.out.print(text);
		text = "Nome do medico: "+p1.getNomeMedico() + "\n";
        s = s + text ;
		System.out.print(text);
		text = "Nome do paciente: "+p1.getNomePaciente() + "\n";
        s = s + text ;
		System.out.print(text);
		text = "Quantidade de consultas: "+p1.getAmostra() + "\n";
        s = s + text ;
		System.out.print(text);
		
		text = "\nQuantidade total de consultas: "+((p1.getAmostra() + p2.getAmostra())-3);
        s = s + text ;
		System.out.print(text);

        byte data[] = s.getBytes();
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND))){
            out.write(data, 0, data.length); 
        }catch (IOException x) {
                System.err.println(x);
        }
    }
}