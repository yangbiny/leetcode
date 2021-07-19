package com.impassive.design;

/**
 * 模板方法设计模式
 *
 * @author impassivey
 */
public class TemplateDesign {

  public static void main(String[] args) {
    TemplateAudit templateAudit = new TemplateAudit();
    System.out.println(templateAudit.canAudit(new CanAuditMedia()));
    System.out.println(templateAudit.canAudit(new CanNotAuditMedia()));
  }

  private static class CanAuditMedia implements AuditMedia {

    @Override
    public Integer metaType() {
      return 1;
    }
  }

  private static class CanNotAuditMedia implements AuditMedia {

    @Override
    public Integer metaType() {
      return 2;
    }
  }

  private interface AuditMedia {

    /**
     * 数据类型
     *
     * @return 数据类型
     */
    Integer metaType();
  }

  private static class TemplateAudit {

    public boolean canAudit(AuditMedia auditMedia) {

      if (auditMedia == null) {
        return false;
      }
      Integer metaType = auditMedia.metaType();
      return metaType == 1;
    }
  }
}
