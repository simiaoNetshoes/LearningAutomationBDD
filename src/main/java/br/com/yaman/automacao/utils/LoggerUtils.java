package br.com.yaman.automacao.utils;

import org.apache.log4j.Logger;

/**
 * 
 * Propósito da classe: Gerar objetos correspondentes aos produtos exibidos na
 * pagina arqmazenando seus principais atributos
 *
 * @since 09 de Dez de 2017 07:37:19
 * @author Daniel Simião<BR>
 *         DesafioYaman<BR>
 * 
 */
public class LoggerUtils {
	
	private Class<?> clazz = null;
	
	/**
	 * Construtor
	 * @param clazz
	 */
	public LoggerUtils(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Info
	 * @param mensagem
	 */
	public void info(String mensagem) {
		Logger logger = Logger.getLogger(clazz);
		logger.info(mensagem);
	}
	
	/**
	 * Debug
	 * @param mensagem
	 */
	public void debug(String mensagem) {
		Logger logger = Logger.getLogger(clazz);
		logger.debug(mensagem);
	}
	
	/**
	 * Error
	 * @param mensagem
	 */
	public void error(String mensagem) {
		Logger logger = Logger.getLogger(clazz);
		logger.error(mensagem);
	}
	
	/**
	 * Error with exception
	 * @param mensagem
	 * @param e
	 */
	public void error(String mensagem, Throwable e) {
		Logger logger = Logger.getLogger(clazz);
		logger.error(mensagem, e);
	}
	
	/**
	 * Fatal
	 * @param mensagem
	 */
	public void fatal(String mensagem) {
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(mensagem);
	}
	
	/**
	 * Fatal with exception
	 * @param mensagem
	 * @param e
	 */
	public void fatal(String mensagem, Throwable e) {
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(mensagem, e);
	}

}
