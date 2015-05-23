package amdantas.aula09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class MainArquivos {

	public static void main(String[] args) {
		
		File diretorio =  new File("C:\\AulaArquivos\\sdsd\\sdsd");
		
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		File arquivo = new File(diretorio, "novo_arquivo.txt");
		if (!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// renomeando
		arquivo.renameTo(new File(diretorio, "novo_arquivo_renomeado.txt"));
		
//		se quiser remover o arquivo
//		arquivo.delete();
		
		
		
		try {
			FileWriter fw = new FileWriter( arquivo );
			
			
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Segundo texto");
			pw.println(34);
			pw.println(false);
			pw.close();
			
//			BufferedWriter bw = new BufferedWriter( fw );
//			bw.write("Texto a ser escrito no txt" );
//			bw.newLine();
//			bw.close();
			
			Aluno a = new Aluno();
			a.setMatricula(2015223232);
			a.setNome("Nome do Aluno");
			PrintWriter w2 = new PrintWriter(new File(diretorio, "arq_aluno.txt"));
			w2.println(a.getMatricula() + ": " + a.getNome());
			w2.close();
			
			PrintWriter w1 = new PrintWriter(new File(diretorio, "arq_aluno_obj.txt"));
			w1.println(a);
			w1.close();

			fw.close();
			
			
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
			}
			
			br.close();
			fr.close();
			
			
			Aluno andre = new Aluno("Andre", 201512323);
			
			Aluno[] vetor = new Aluno[] {
					andre, 
					new Aluno("joao", 2093293),
					new Aluno("maria", 209329333)
			};
			
			File arq = new File (diretorio, "aluno_obj.dat");
			FileOutputStream fout = new FileOutputStream(arq);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(vetor);
			
            oos.close();
            fout.close();
            
            
            FileInputStream fis = new FileInputStream(arq);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Aluno[] v = (Aluno[]) ois.readObject();
            for (Aluno aluno : v) {
				System.out.println(aluno.getMatricula());
				a.setNome("nome alterado");
			}
//            Object obj = ois.readObject();
//            try {
//            	do {
//                	Aluno aluno = (Aluno) obj;
//                	System.out.println(aluno.getNome());
//                	obj = ois.readObject();
//                } while (obj != null);
//            } catch (EOFException e) {
//            	
//            }
            
            
            ois.close();
            fis.close();
            
            
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
