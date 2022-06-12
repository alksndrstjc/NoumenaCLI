package org.example.service.writer;

import org.example.model.Model;

import java.util.List;

public class HtmlWriter implements Writer {

    @Override
    public void write(List<Model> models) {
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n");
        sb.append("<html>").append("<body>");
        sb.append("<table>")
                .append("<tr>")
                .append("<th>").append(Model.Field.NAME.value).append("</th>")
                .append("<th>").append(Model.Field.ADDRESS.value).append("</th>")
                .append("<th>").append(Model.Field.POSTCODE.value).append("</th>")
                .append("<th>").append(Model.Field.PHONE.value).append("</th>")
                .append("<th>").append(Model.Field.CREDIT_LIMIT.value).append("</th>")
                .append("<th>").append(Model.Field.BIRTHDAY.value).append("</th></tr>");
        models.forEach(model -> {
            sb.append("<tr>");
            sb.append("<td>").append(model.getName()).append("</td>");
            sb.append("<td>").append(model.getAddress()).append("</td>");
            sb.append("<td>").append(model.getPostcode()).append("</td>");
            sb.append("<td>").append(model.getPhone()).append("</td>");
            sb.append("<td>").append(model.getCreditLimit()).append("</td>");
            sb.append("<td>").append(model.getBirthday()).append("</td>");
            sb.append("</tr>");
        });
        sb.append("</table></body></html>");
        System.out.println(sb);
    }
}
