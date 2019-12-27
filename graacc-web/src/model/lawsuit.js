class Lawsuit {
  constructor(idprocess, typeClass, subject, judge, district, forum, court, dateAvailability, description) {
    this.idprocess = idprocess;
    this.typeClass = typeClass;
    this.subject = subject;
    this.judge = judge;
    this.district = district;
    this.forum = forum;
    this.court = court;
    this.dateAvailability = dateAvailability;
    this.description = description;
  }
}

export default Lawsuit;
