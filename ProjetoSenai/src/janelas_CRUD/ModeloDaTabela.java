package janelas_CRUD;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloDaTabela extends AbstractTableModel{
	
	private String[] colunas = null;
	private ArrayList linhas = null;
	
	public ModeloDaTabela(String[] colunas,ArrayList linhas) {
		this.colunas = colunas;
		this.linhas = linhas;
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object[] linha = (Object[])getLinhas().get(arg0);
		return linha[arg1];
	}
	
	public String getColumnName(int arg1) {
		return colunas[arg1];
	}
	
	//getters e setters
	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}

}
