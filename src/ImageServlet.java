import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");

		try {
			// Bild mit 200 mal 200 erzeugen!
			BufferedImage bufferedImage = new BufferedImage(200, 200,
					BufferedImage.TYPE_INT_RGB);

			int random;
			random = (int) Math.floor((Math.random() * 5) + 1);

			// form;
			Color farbe;
			Graphics g = bufferedImage.getGraphics();

			switch (random) {
			case 1:
				random = 1;
				g.setColor(Color.ORANGE);
				g.fillRect(0, 0, 100, 100);
				break;
			case 2:
				random = 2;
				g.setColor(Color.BLUE);
				g.fillOval(0, 0, 150, 150);
				break;
			case 3:
				random = 3;
				g.setColor(Color.green);
				g.drawString("ATA IST STUPID", 20, 20);
				break;
			case 4:
				random = 4;
				g.setColor(Color.MAGENTA);
				g.drawRoundRect(0, 0, 100, 500, 20, 20);
				break;
			case 5:
				random = 5;
				g.setColor(Color.RED);
				g.drawLine(20, 30, 100, 100);
				break;

			}

			g.dispose();

			// JPG speichern
			ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		} catch (IOException ioe) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
