package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class View_005fNear_005fHosp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Nearby Hospitals</title>    \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet/dist/leaflet.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.css\">\n");
      out.write("        <style>\n");
      out.write("            #map {\n");
      out.write("                height: 600px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"https://unpkg.com/leaflet/dist/leaflet.js\"></script>\n");
      out.write("        <script src=\"https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.js\"></script>\n");
      out.write("        <script src=\"https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-directions/v5.0.1/mapbox-gl-directions.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("           document.addEventListener('DOMContentLoaded', function() {\n");
      out.write("    mapboxgl.accessToken = 'YOUR_MAPBOX_ACCESS_TOKEN'; // Replace with your Mapbox Access Token\n");
      out.write("\n");
      out.write("    function initMap(lat, lon) {\n");
      out.write("        var map = L.map('map').setView([lat, lon], 13);\n");
      out.write("\n");
      out.write("        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n");
      out.write("            maxZoom: 18,\n");
      out.write("            attribution: 'Map data &copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n");
      out.write("        }).addTo(map);\n");
      out.write("\n");
      out.write("        L.marker([lat, lon]).addTo(map)\n");
      out.write("            .bindPopup(\"You are here\")\n");
      out.write("            .openPopup();\n");
      out.write("\n");
      out.write("        fetchNearbyHospitals(lat, lon, map);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function fetchNearbyHospitals(lat, lon, map) {\n");
      out.write("        var radius = 2000; // Search radius in meters (2 km)\n");
      out.write("        var query = '[out:json];' +\n");
      out.write("                    '(' +\n");
      out.write("                    'node[\"amenity\"=\"hospital\"](around:' + radius + ', ' + lat + ', ' + lon + ');' +\n");
      out.write("                    ');' +\n");
      out.write("                    'out;';\n");
      out.write("        \n");
      out.write("        fetch('https://overpass-api.de/api/interpreter?data=' + encodeURIComponent(query))\n");
      out.write("            .then(function(response) {\n");
      out.write("                return response.json();\n");
      out.write("            })\n");
      out.write("            .then(function(data) {\n");
      out.write("                var nearestHospital = null;\n");
      out.write("                var minDistance = Infinity;\n");
      out.write("                \n");
      out.write("                data.elements.forEach(function(element) {\n");
      out.write("                    var hospitalLat = element.lat;\n");
      out.write("                    var hospitalLon = element.lon;\n");
      out.write("                    var distance = getDistance(lat, lon, hospitalLat, hospitalLon);\n");
      out.write("                    \n");
      out.write("                    if (distance < minDistance) {\n");
      out.write("                        minDistance = distance;\n");
      out.write("                        nearestHospital = { lat: hospitalLat, lon: hospitalLon, name: element.tags.name || \"Hospital\" };\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    L.marker([element.lat, element.lon]).addTo(map)\n");
      out.write("                        .bindPopup(element.tags.name || \"Hospital\");\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                if (nearestHospital) {\n");
      out.write("                    L.marker([nearestHospital.lat, nearestHospital.lon]).addTo(map)\n");
      out.write("                        .bindPopup('Nearest Hospital: ' + nearestHospital.name)\n");
      out.write("                        .openPopup();\n");
      out.write("                    getRoute(lat, lon, nearestHospital.lat, nearestHospital.lon, map);\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("            .catch(function(error) {\n");
      out.write("                console.error('Error fetching hospital data:', error);\n");
      out.write("            });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function getDistance(lat1, lon1, lat2, lon2) {\n");
      out.write("        var R = 6371; // Radius of the earth in km\n");
      out.write("        var dLat = (lat2 - lat1) * Math.PI / 180;\n");
      out.write("        var dLon = (lon2 - lon1) * Math.PI / 180;\n");
      out.write("        var a = \n");
      out.write("            0.5 - Math.cos(dLat)/2 +\n");
      out.write("            Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) * \n");
      out.write("            (1 - Math.cos(dLon)) / 2;\n");
      out.write("\n");
      out.write("        return R * 2 * Math.asin(Math.sqrt(a)) * 1000; // Distance in meters\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function getRoute(startLat, startLon, endLat, endLon, map) {\n");
      out.write("        var directions = new mapboxgl.Directions({\n");
      out.write("            accessToken: mapboxgl.accessToken,\n");
      out.write("            unit: 'metric',\n");
      out.write("            profile: 'mapbox/driving',\n");
      out.write("            controls: {\n");
      out.write("                inputs: false,\n");
      out.write("                instructions: true\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        map.addControl(directions, 'top-left');\n");
      out.write("        directions.setOrigin([startLon, startLat]);\n");
      out.write("        directions.setDestination([endLon, endLat]);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function getUserLocation() {\n");
      out.write("        navigator.geolocation.getCurrentPosition(function(position) {\n");
      out.write("            var lat = position.coords.latitude;\n");
      out.write("            var lon = position.coords.longitude;\n");
      out.write("            initMap(lat, lon);\n");
      out.write("        }, function(error) {\n");
      out.write("            console.error('Error getting location:', error.message);\n");
      out.write("            alert('Unable to retrieve your location. Please check your browser settings.');\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    getUserLocation();\n");
      out.write("});\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Nearby Hospitals with Route</h1>\n");
      out.write("        <div id=\"map\"></div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
